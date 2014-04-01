package hr.ponge.cubis.grec.model;

import hr.ponge.cubis.Constants;
import hr.ponge.cubis.grec.GrecUtil;
import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GrecMesh {

    private static final Logger logger = Logger.getLogger(GrecMesh.class.getName());
    /**
     * Mesh resolution
     */
    public static final int resolution = 16;
    private GrecPoint[][] mesh = new GrecPoint[resolution][resolution];
    private List<GrecPoint> points = new ArrayList<GrecPoint>();

    public GrecPoint getPoint(int x, int y) {
        return mesh[x][y];

    }

    public void clearMash() {
        points.clear();
        for (int x = 0; x < GrecMesh.resolution; x++) {
            for (int y = 0; y < GrecMesh.resolution; y++) {
                mesh[x][y] = null;

            }
        }
    }

    public void mapRequest(List<int[]> req) {
         logger.log(Level.FINE, "REQUEST POINTS size={0}", req.size());
        for(int[] a:req){
           logger.log(Level.FINE, "{0}-{1}", new Object[]{a[0], a[1]}); 
        }
        
        clearMash();


        List<double[]> norm = GrecUtil.normalizeMesh(req);

        double[] cent = GrecUtil.findCenteroid(norm);

        List<int[]> mash = GrecUtil
                .mapPointsToMash(norm, GrecMesh.resolution, cent);


        int ordinal = 0;
        for (int[] m : mash) {
            points.add(new GrecPoint(ordinal, m[0], m[1]));

            ordinal++;
        }
        removeDoublePoints();
        fillGaps();
        logger.log(Level.FINE, "FINAL GREC POINTS");
        for (GrecPoint gp : points) {
            logger.log(Level.FINE, gp.toString());
            mesh[(int) gp.getX()][(int) gp.getY()] = gp;
        }



    }

    private void removeDoublePoints() {
        GrecPoint remove = null;

        for (GrecPoint p : points) {
            GrecPoint next = null;
            if (points.size() > (int) (p.getOrdinal() + 1)) {
                next = points.get((int) (p.getOrdinal() + 1));
            }
            if (next == null) {
                continue;
            }
            if (p.getX() == next.getX() && p.getY() == next.getY()) {
                remove = next;
            }
        }

        if (remove != null) {

            points.remove(remove);

            fixOrdinals();
            removeDoublePoints();
        }
    }

    private void fixOrdinals() {
        for (int i = 0; i < points.size(); i++) {
            points.get(i).setOrdinal(i);
        }
    }

    private void fillGaps() {

        GrecPoint addPoint = null;

        for (GrecPoint p : points) {
            GrecPoint next = null;
            if (points.size() > (int) (p.getOrdinal() + 1)) {
                next = points.get((int) (p.getOrdinal() + 1));
            }
            if (next == null) {
                continue;
            }
            boolean adjacent = isAdjacent(p, next);
            if (adjacent) {
                continue;
            }
            addPoint = new GrecPoint(p.getOrdinal(), 0, 0);
            double deltaX = next.getX() - p.getX();
            double deltaY = next.getY() - p.getY();
            addPoint.setX(p.getX());
            addPoint.setY(p.getY());
            if (Math.abs(deltaX) > 0) {
                boolean doit = true;
                if (Math.abs(deltaX) == 1) {
                    if (Math.random() > 0.5d) {

                        doit = false;
                    } else {

                        doit = true;
                    }
                }
                if (doit) {
                    if (Math.signum(deltaX) > 0) {
                        addPoint.setX(addPoint.getX() + 1);
                    } else {
                        addPoint.setX(addPoint.getX() - 1);
                    }
                }

            }
            if (Math.abs(deltaY) > 0) {
                boolean doit = true;
                if (Math.abs(deltaY) == 1) {
                    if (Math.random() > 0.5d) {

                        doit = false;
                    } else {

                        doit = true;
                    }
                }
                if (doit) {
                    if (Math.signum(deltaY) > 0) {
                        addPoint.setY(addPoint.getY() + 1);
                    } else {
                        addPoint.setY(addPoint.getY() - 1);
                    }
                }
            }
            break;
        }
        if (addPoint != null) {
            points.add((int) addPoint.getOrdinal() + 1, addPoint);
            fixOrdinals();
            fillGaps();
        }

    }

    private boolean isAdjacent(GrecPoint p, GrecPoint next) {
        double absX = Math.abs(p.getX() - next.getX());
        double absY = Math.abs(p.getY() - next.getY());

        if (absX > 1) {
            return false;
        }
        if (absY > 1) {
            return false;
        }

        return true;
    }

    public String analize() {
        HashMap<String[], Double> score = new HashMap<String[], Double>();

        Set<Entry<String[], List<GrecPoint>>> set = GrecUtil.templates.entrySet();
        for (Entry<String[], List<GrecPoint>> e : set) {
            double mappingKoef = 1;
            List<GrecPoint> tPoints = e.getValue();
            mappingKoef = ((double) tPoints.size()) / ((double) points.size());
            double distanceScore = 0;

            for (GrecPoint p : points) {
                int poz = (int) Math.round(p.getOrdinal() * mappingKoef);
                if (poz == tPoints.size()) {
                    poz = tPoints.size() - 1;
                }
                GrecPoint tp = tPoints.get(poz);
                distanceScore += getDistanceScore(p, tp);
            }
            score.put(e.getKey(), distanceScore);

        }

        Set<Entry<String[], Double>> es = score.entrySet();
        String rez = null;
        double minScore = 9999999;
        for (Entry<String[], Double> e : es) {

            if (e.getValue() < minScore) {
                minScore = e.getValue();
                rez = e.getKey()[1];
            }
        }

        if (minScore > 200) {
            logger.fine("GREC RESULT IS NULL");
            return Constants.NULL;
        }

        logger.log(Level.FINE, "GREC RESULT IS {0}", rez);
        return rez;

    }

    private double getDistanceScore(GrecPoint p, GrecPoint tp) {
        double absX = Math.abs(p.getX() - tp.getX());
        double absY = Math.abs(p.getY() - tp.getY());
        return absX + absY;
    }
}
