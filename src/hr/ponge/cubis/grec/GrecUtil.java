package hr.ponge.cubis.grec;

import hr.ponge.cubis.Constants;
import hr.ponge.cubis.grec.model.GrecMesh;
import hr.ponge.cubis.grec.model.GrecPoint;
import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;


public class GrecUtil {
	
	

	public static final HashMap<String[], List<GrecPoint>> templates = new HashMap<String[], List<GrecPoint>>();

	static {
		List<GrecPoint> templateRight = new ArrayList<GrecPoint>();
		templateRight.add(new GrecPoint(0, 0, 8));
		templateRight.add(new GrecPoint(1, 1, 8));
		templateRight.add(new GrecPoint(2, 1, 7));
		templateRight.add(new GrecPoint(3, 2, 7));
		templateRight.add(new GrecPoint(4, 3, 7));
		templateRight.add(new GrecPoint(5, 4, 7));
		templateRight.add(new GrecPoint(6, 5, 7));
		templateRight.add(new GrecPoint(7, 6, 7));
		templateRight.add(new GrecPoint(8, 7, 7));
		templateRight.add(new GrecPoint(9, 8, 7));
		templateRight.add(new GrecPoint(10, 9, 7));
		templateRight.add(new GrecPoint(11, 10, 7));
		templateRight.add(new GrecPoint(12, 10, 8));
		templateRight.add(new GrecPoint(13, 11, 8));
		templateRight.add(new GrecPoint(14, 12, 8));
		templateRight.add(new GrecPoint(15, 13, 8));
		templateRight.add(new GrecPoint(16, 14, 8));
		templateRight.add(new GrecPoint(17, 15, 8));

		templates.put(new String[]{"right",Constants.RIGHT_MOVE}, templateRight);

		List<GrecPoint> templateLeft = new ArrayList<GrecPoint>();
		templateLeft.add(new GrecPoint(0, 15, 8));
		templateLeft.add(new GrecPoint(1, 14, 8));
		templateLeft.add(new GrecPoint(2, 13, 7));
		templateLeft.add(new GrecPoint(3, 12, 7));
		templateLeft.add(new GrecPoint(4, 11, 7));
		templateLeft.add(new GrecPoint(5, 10, 7));
		templateLeft.add(new GrecPoint(6, 9, 7));
		templateLeft.add(new GrecPoint(7, 8, 7));
		templateLeft.add(new GrecPoint(8, 7, 7));
		templateLeft.add(new GrecPoint(9, 6, 7));
		templateLeft.add(new GrecPoint(10, 5, 7));
		templateLeft.add(new GrecPoint(11, 4, 7));
		templateLeft.add(new GrecPoint(12, 3, 8));
		templateLeft.add(new GrecPoint(13, 2, 8));
		templateLeft.add(new GrecPoint(14, 1, 8));
		templateLeft.add(new GrecPoint(15, 0, 8));
		templates.put(new String[]{"left",Constants.LEFT_MOVE}, templateLeft);

		List<GrecPoint> templateCW = new ArrayList<GrecPoint>();
		templateCW.add(new GrecPoint(0.0, 8.0, 0.0));
		templateCW.add(new GrecPoint(1.0, 9.0, 0.0));
		templateCW.add(new GrecPoint(2.0, 10.0, 1.0));
		templateCW.add(new GrecPoint(3.0, 11.0, 1.0));
		templateCW.add(new GrecPoint(4.0, 12.0, 1.0));
		templateCW.add(new GrecPoint(5.0, 12.0, 2.0));
		templateCW.add(new GrecPoint(6.0, 13.0, 2.0));
		templateCW.add(new GrecPoint(7.0, 13.0, 3.0));
		templateCW.add(new GrecPoint(8.0, 14.0, 3.0));
		templateCW.add(new GrecPoint(9.0, 14.0, 4.0));
		templateCW.add(new GrecPoint(10.0, 15.0, 4.0));
		templateCW.add(new GrecPoint(11.0, 15.0, 5.0));
		templateCW.add(new GrecPoint(12.0, 15.0, 6.0));
		templateCW.add(new GrecPoint(13.0, 15.0, 7.0));
		templateCW.add(new GrecPoint(14.0, 15.0, 8.0));
		templateCW.add(new GrecPoint(15.0, 15.0, 9.0));
		templateCW.add(new GrecPoint(16.0, 15.0, 10.0));
		templateCW.add(new GrecPoint(17.0, 14.0, 10.0));
		templateCW.add(new GrecPoint(18.0, 14.0, 11.0));
		templateCW.add(new GrecPoint(19.0, 13.0, 11.0));
		templateCW.add(new GrecPoint(20.0, 13.0, 12.0));
		templateCW.add(new GrecPoint(21.0, 12.0, 12.0));
		templateCW.add(new GrecPoint(22.0, 11.0, 12.0));
		templateCW.add(new GrecPoint(23.0, 11.0, 13.0));
		templateCW.add(new GrecPoint(24.0, 10.0, 13.0));
		templateCW.add(new GrecPoint(25.0, 10.0, 14.0));
		templateCW.add(new GrecPoint(26.0, 9.0, 14.0));
		templateCW.add(new GrecPoint(27.0, 8.0, 14.0));
		templateCW.add(new GrecPoint(28.0, 7.0, 14.0));
		templateCW.add(new GrecPoint(29.0, 6.0, 14.0));
		templateCW.add(new GrecPoint(30.0, 5.0, 14.0));
		templateCW.add(new GrecPoint(31.0, 5.0, 13.0));
		templateCW.add(new GrecPoint(32.0, 4.0, 13.0));
		templateCW.add(new GrecPoint(33.0, 3.0, 13.0));
		templateCW.add(new GrecPoint(34.0, 2.0, 13.0));
		templateCW.add(new GrecPoint(35.0, 2.0, 12.0));
		templateCW.add(new GrecPoint(36.0, 1.0, 12.0));
		templateCW.add(new GrecPoint(37.0, 1.0, 11.0));
		templateCW.add(new GrecPoint(38.0, 1.0, 10.0));
		templateCW.add(new GrecPoint(39.0, 0.0, 10.0));
		templateCW.add(new GrecPoint(40.0, 0.0, 9.0));
		templateCW.add(new GrecPoint(41.0, 0.0, 8.0));
		templateCW.add(new GrecPoint(42.0, 0.0, 7.0));
		templateCW.add(new GrecPoint(43.0, 0.0, 6.0));
		templateCW.add(new GrecPoint(44.0, 0.0, 5.0));
		templateCW.add(new GrecPoint(45.0, 1.0, 5.0));
		templateCW.add(new GrecPoint(46.0, 1.0, 4.0));
		templateCW.add(new GrecPoint(47.0, 2.0, 4.0));
		templateCW.add(new GrecPoint(48.0, 2.0, 3.0));
		templateCW.add(new GrecPoint(49.0, 2.0, 2.0));
		templateCW.add(new GrecPoint(50.0, 3.0, 2.0));
		templateCW.add(new GrecPoint(51.0, 3.0, 1.0));
		templateCW.add(new GrecPoint(52.0, 4.0, 1.0));
		templateCW.add(new GrecPoint(53.0, 5.0, 1.0));
		templateCW.add(new GrecPoint(54.0, 6.0, 1.0));
		templates.put(new String[]{"circle_cw1",Constants.CIRCLE_CW}, templateCW);

		List<GrecPoint> templateDown = new ArrayList<GrecPoint>();
		templateDown.add(new GrecPoint(0.0, 7.0, 0.0));
		templateDown.add(new GrecPoint(1.0, 7.0, 1.0));
		templateDown.add(new GrecPoint(2.0, 7.0, 2.0));
		templateDown.add(new GrecPoint(3.0, 8.0, 3.0));
		templateDown.add(new GrecPoint(4.0, 8.0, 4.0));
		templateDown.add(new GrecPoint(5.0, 8.0, 5.0));
		templateDown.add(new GrecPoint(6.0, 8.0, 6.0));
		templateDown.add(new GrecPoint(7.0, 8.0, 7.0));
		templateDown.add(new GrecPoint(8.0, 8.0, 8.0));
		templateDown.add(new GrecPoint(9.0, 8.0, 9.0));
		templateDown.add(new GrecPoint(10.0, 8.0, 10.0));
		templateDown.add(new GrecPoint(11.0, 8.0, 11.0));
		templateDown.add(new GrecPoint(12.0, 8.0, 12.0));
		templateDown.add(new GrecPoint(13.0, 8.0, 13.0));
		templateDown.add(new GrecPoint(14.0, 7.0, 13.0));
		templateDown.add(new GrecPoint(15.0, 7.0, 14.0));
		templateDown.add(new GrecPoint(16.0, 7.0, 15.0));
		templates.put(new String[]{"down",Constants.DOWN_MOVE}, templateDown);

		List<GrecPoint> templateUp = new ArrayList<GrecPoint>();
		templateUp.add(new GrecPoint(0.0, 8.0, 15.0));
		templateUp.add(new GrecPoint(1.0, 8.0, 14.0));
		templateUp.add(new GrecPoint(2.0, 8.0, 13.0));
		templateUp.add(new GrecPoint(3.0, 8.0, 12.0));
		templateUp.add(new GrecPoint(4.0, 8.0, 11.0));
		templateUp.add(new GrecPoint(5.0, 8.0, 10.0));
		templateUp.add(new GrecPoint(6.0, 8.0, 9.0));
		templateUp.add(new GrecPoint(7.0, 8.0, 8.0));
		templateUp.add(new GrecPoint(8.0, 8.0, 7.0));
		templateUp.add(new GrecPoint(9.0, 8.0, 6.0));
		templateUp.add(new GrecPoint(10.0, 7.0, 6.0));
		templateUp.add(new GrecPoint(11.0, 7.0, 5.0));
		templateUp.add(new GrecPoint(12.0, 7.0, 4.0));
		templateUp.add(new GrecPoint(13.0, 7.0, 3.0));
		templateUp.add(new GrecPoint(14.0, 7.0, 2.0));
		templateUp.add(new GrecPoint(15.0, 7.0, 1.0));
		templateUp.add(new GrecPoint(16.0, 7.0, 0.0));
		templates.put(new String[]{"up",Constants.UP_MOVE}, templateUp);

		ArrayList<GrecPoint> template = new ArrayList<GrecPoint>();
		template.add(new GrecPoint(0.0, 13.0, 8.0));
		template.add(new GrecPoint(1.0, 13.0, 9.0));
		template.add(new GrecPoint(2.0, 13.0, 10.0));
		template.add(new GrecPoint(3.0, 13.0, 11.0));
		template.add(new GrecPoint(4.0, 12.0, 11.0));
		template.add(new GrecPoint(5.0, 12.0, 12.0));
		template.add(new GrecPoint(6.0, 11.0, 13.0));
		template.add(new GrecPoint(7.0, 10.0, 14.0));
		template.add(new GrecPoint(8.0, 9.0, 14.0));
		template.add(new GrecPoint(9.0, 8.0, 14.0));
		template.add(new GrecPoint(10.0, 8.0, 15.0));
		template.add(new GrecPoint(11.0, 7.0, 15.0));
		template.add(new GrecPoint(12.0, 6.0, 15.0));
		template.add(new GrecPoint(13.0, 5.0, 15.0));
		template.add(new GrecPoint(14.0, 4.0, 15.0));
		template.add(new GrecPoint(15.0, 3.0, 14.0));
		template.add(new GrecPoint(16.0, 2.0, 14.0));
		template.add(new GrecPoint(17.0, 2.0, 13.0));
		template.add(new GrecPoint(18.0, 2.0, 12.0));
		template.add(new GrecPoint(19.0, 1.0, 12.0));
		template.add(new GrecPoint(20.0, 1.0, 11.0));
		template.add(new GrecPoint(21.0, 1.0, 10.0));
		template.add(new GrecPoint(22.0, 1.0, 9.0));
		template.add(new GrecPoint(23.0, 1.0, 8.0));
		template.add(new GrecPoint(24.0, 1.0, 7.0));
		template.add(new GrecPoint(25.0, 1.0, 6.0));
		template.add(new GrecPoint(26.0, 1.0, 5.0));
		template.add(new GrecPoint(27.0, 2.0, 4.0));
		template.add(new GrecPoint(28.0, 2.0, 3.0));
		template.add(new GrecPoint(29.0, 2.0, 2.0));
		template.add(new GrecPoint(30.0, 3.0, 2.0));
		template.add(new GrecPoint(31.0, 3.0, 1.0));
		template.add(new GrecPoint(32.0, 4.0, 1.0));
		template.add(new GrecPoint(33.0, 5.0, 0.0));
		template.add(new GrecPoint(34.0, 6.0, 0.0));
		template.add(new GrecPoint(35.0, 7.0, 0.0));
		template.add(new GrecPoint(36.0, 8.0, 0.0));
		template.add(new GrecPoint(37.0, 9.0, 0.0));
		template.add(new GrecPoint(38.0, 9.0, 1.0));
		template.add(new GrecPoint(39.0, 10.0, 1.0));
		template.add(new GrecPoint(40.0, 10.0, 2.0));
		template.add(new GrecPoint(41.0, 11.0, 2.0));
		template.add(new GrecPoint(42.0, 11.0, 3.0));
		template.add(new GrecPoint(43.0, 11.0, 4.0));
		template.add(new GrecPoint(44.0, 12.0, 4.0));
		template.add(new GrecPoint(45.0, 12.0, 5.0));
		template.add(new GrecPoint(46.0, 13.0, 6.0));
		template.add(new GrecPoint(47.0, 13.0, 7.0));
		template.add(new GrecPoint(48.0, 13.0, 6.0));
		templates.put(new String[]{"circle_cw2",Constants.CIRCLE_CW}, template);

		template = new ArrayList<GrecPoint>();
		template.add(new GrecPoint(0.0, 8.0, 13.0));
		template.add(new GrecPoint(1.0, 7.0, 13.0));
		template.add(new GrecPoint(2.0, 6.0, 13.0));
		template.add(new GrecPoint(3.0, 5.0, 13.0));
		template.add(new GrecPoint(4.0, 5.0, 12.0));
		template.add(new GrecPoint(5.0, 4.0, 12.0));
		template.add(new GrecPoint(6.0, 3.0, 12.0));
		template.add(new GrecPoint(7.0, 2.0, 11.0));
		template.add(new GrecPoint(8.0, 1.0, 11.0));
		template.add(new GrecPoint(9.0, 1.0, 10.0));
		template.add(new GrecPoint(10.0, 0.0, 10.0));
		template.add(new GrecPoint(11.0, 0.0, 9.0));
		template.add(new GrecPoint(12.0, 0.0, 8.0));
		template.add(new GrecPoint(13.0, 0.0, 7.0));
		template.add(new GrecPoint(14.0, 0.0, 6.0));
		template.add(new GrecPoint(15.0, 1.0, 6.0));
		template.add(new GrecPoint(16.0, 1.0, 5.0));
		template.add(new GrecPoint(17.0, 2.0, 4.0));
		template.add(new GrecPoint(18.0, 2.0, 3.0));
		template.add(new GrecPoint(19.0, 2.0, 2.0));
		template.add(new GrecPoint(20.0, 3.0, 2.0));
		template.add(new GrecPoint(21.0, 3.0, 1.0));
		template.add(new GrecPoint(22.0, 4.0, 1.0));
		template.add(new GrecPoint(23.0, 4.0, 0.0));
		template.add(new GrecPoint(24.0, 5.0, 0.0));
		template.add(new GrecPoint(25.0, 6.0, 0.0));
		template.add(new GrecPoint(26.0, 7.0, 0.0));
		template.add(new GrecPoint(27.0, 8.0, 0.0));
		template.add(new GrecPoint(28.0, 9.0, 0.0));
		template.add(new GrecPoint(29.0, 10.0, 0.0));
		template.add(new GrecPoint(30.0, 11.0, 0.0));
		template.add(new GrecPoint(31.0, 11.0, 1.0));
		template.add(new GrecPoint(32.0, 12.0, 2.0));
		template.add(new GrecPoint(33.0, 13.0, 3.0));
		template.add(new GrecPoint(34.0, 14.0, 4.0));
		template.add(new GrecPoint(35.0, 14.0, 5.0));
		template.add(new GrecPoint(36.0, 14.0, 6.0));
		template.add(new GrecPoint(37.0, 15.0, 6.0));
		template.add(new GrecPoint(38.0, 15.0, 7.0));
		template.add(new GrecPoint(39.0, 15.0, 8.0));
		template.add(new GrecPoint(40.0, 15.0, 9.0));
		template.add(new GrecPoint(41.0, 15.0, 10.0));
		template.add(new GrecPoint(42.0, 14.0, 10.0));
		template.add(new GrecPoint(43.0, 14.0, 11.0));
		template.add(new GrecPoint(44.0, 14.0, 12.0));
		template.add(new GrecPoint(45.0, 13.0, 12.0));
		template.add(new GrecPoint(46.0, 13.0, 13.0));
		template.add(new GrecPoint(47.0, 12.0, 13.0));
		template.add(new GrecPoint(48.0, 11.0, 14.0));
		template.add(new GrecPoint(49.0, 10.0, 14.0));
		template.add(new GrecPoint(50.0, 9.0, 14.0));
		template.add(new GrecPoint(51.0, 9.0, 13.0));
		template.add(new GrecPoint(52.0, 8.0, 13.0));
		templates.put(new String[]{"circle_cw3",Constants.CIRCLE_CW}, template);

		template = new ArrayList<GrecPoint>();
		template.add(new GrecPoint(0.0, 2.0, 7.0));
		template.add(new GrecPoint(1.0, 2.0, 6.0));
		template.add(new GrecPoint(2.0, 2.0, 5.0));
		template.add(new GrecPoint(3.0, 2.0, 4.0));
		template.add(new GrecPoint(4.0, 2.0, 3.0));
		template.add(new GrecPoint(5.0, 3.0, 3.0));
		template.add(new GrecPoint(6.0, 3.0, 2.0));
		template.add(new GrecPoint(7.0, 4.0, 2.0));
		template.add(new GrecPoint(8.0, 4.0, 1.0));
		template.add(new GrecPoint(9.0, 5.0, 1.0));
		template.add(new GrecPoint(10.0, 5.0, 0.0));
		template.add(new GrecPoint(11.0, 6.0, 0.0));
		template.add(new GrecPoint(12.0, 7.0, 0.0));
		template.add(new GrecPoint(13.0, 8.0, 0.0));
		template.add(new GrecPoint(14.0, 9.0, 0.0));
		template.add(new GrecPoint(15.0, 9.0, 1.0));
		template.add(new GrecPoint(16.0, 10.0, 1.0));
		template.add(new GrecPoint(17.0, 11.0, 1.0));
		template.add(new GrecPoint(18.0, 11.0, 2.0));
		template.add(new GrecPoint(19.0, 12.0, 2.0));
		template.add(new GrecPoint(20.0, 13.0, 3.0));
		template.add(new GrecPoint(21.0, 13.0, 4.0));
		template.add(new GrecPoint(22.0, 14.0, 4.0));
		template.add(new GrecPoint(23.0, 14.0, 5.0));
		template.add(new GrecPoint(24.0, 15.0, 6.0));
		template.add(new GrecPoint(25.0, 15.0, 7.0));
		template.add(new GrecPoint(26.0, 15.0, 8.0));
		template.add(new GrecPoint(27.0, 15.0, 9.0));
		template.add(new GrecPoint(28.0, 15.0, 10.0));
		template.add(new GrecPoint(29.0, 15.0, 11.0));
		template.add(new GrecPoint(30.0, 14.0, 11.0));
		template.add(new GrecPoint(31.0, 14.0, 12.0));
		template.add(new GrecPoint(32.0, 14.0, 13.0));
		template.add(new GrecPoint(33.0, 13.0, 13.0));
		template.add(new GrecPoint(34.0, 13.0, 14.0));
		template.add(new GrecPoint(35.0, 12.0, 14.0));
		template.add(new GrecPoint(36.0, 12.0, 15.0));
		template.add(new GrecPoint(37.0, 11.0, 15.0));
		template.add(new GrecPoint(38.0, 10.0, 15.0));
		template.add(new GrecPoint(39.0, 9.0, 15.0));
		template.add(new GrecPoint(40.0, 8.0, 15.0));
		template.add(new GrecPoint(41.0, 7.0, 14.0));
		template.add(new GrecPoint(42.0, 6.0, 14.0));
		template.add(new GrecPoint(43.0, 5.0, 13.0));
		template.add(new GrecPoint(44.0, 4.0, 12.0));
		template.add(new GrecPoint(45.0, 3.0, 12.0));
		template.add(new GrecPoint(46.0, 3.0, 11.0));
		template.add(new GrecPoint(47.0, 2.0, 10.0));
		template.add(new GrecPoint(48.0, 2.0, 9.0));
		template.add(new GrecPoint(49.0, 2.0, 8.0));
		template.add(new GrecPoint(50.0, 2.0, 7.0));
		templates.put(new String[]{"circle_cw4",Constants.CIRCLE_CW}, template);

		template = new ArrayList<GrecPoint>();
		template.add(new GrecPoint(0.0, 2.0, 0.0));
		template.add(new GrecPoint(1.0, 3.0, 0.0));
		template.add(new GrecPoint(2.0, 4.0, 1.0));
		template.add(new GrecPoint(3.0, 5.0, 1.0));
		template.add(new GrecPoint(4.0, 6.0, 2.0));
		template.add(new GrecPoint(5.0, 7.0, 3.0));
		template.add(new GrecPoint(6.0, 8.0, 3.0));
		template.add(new GrecPoint(7.0, 8.0, 4.0));
		template.add(new GrecPoint(8.0, 9.0, 4.0));
		template.add(new GrecPoint(9.0, 10.0, 5.0));
		template.add(new GrecPoint(10.0, 11.0, 6.0));
		template.add(new GrecPoint(11.0, 11.0, 7.0));
		template.add(new GrecPoint(12.0, 11.0, 8.0));
		template.add(new GrecPoint(13.0, 12.0, 8.0));
		template.add(new GrecPoint(14.0, 12.0, 9.0));
		template.add(new GrecPoint(15.0, 11.0, 10.0));
		template.add(new GrecPoint(16.0, 11.0, 11.0));
		template.add(new GrecPoint(17.0, 11.0, 12.0));
		template.add(new GrecPoint(18.0, 10.0, 12.0));
		template.add(new GrecPoint(19.0, 10.0, 13.0));
		template.add(new GrecPoint(20.0, 9.0, 13.0));
		template.add(new GrecPoint(21.0, 8.0, 14.0));
		template.add(new GrecPoint(22.0, 7.0, 14.0));
		template.add(new GrecPoint(23.0, 6.0, 15.0));
		template.add(new GrecPoint(24.0, 5.0, 15.0));
		template.add(new GrecPoint(25.0, 4.0, 15.0));
		template.add(new GrecPoint(26.0, 3.0, 15.0));
		templates.put(new String[]{"circle_cw5",Constants.CIRCLE_CW}, template);

		template = new ArrayList<GrecPoint>();
		template.add(new GrecPoint(0.0, 15.0, 2.0));
		template.add(new GrecPoint(1.0, 15.0, 3.0));
		template.add(new GrecPoint(2.0, 15.0, 4.0));
		template.add(new GrecPoint(3.0, 15.0, 5.0));
		template.add(new GrecPoint(4.0, 15.0, 6.0));
		template.add(new GrecPoint(5.0, 14.0, 7.0));
		template.add(new GrecPoint(6.0, 14.0, 8.0));
		template.add(new GrecPoint(7.0, 13.0, 9.0));
		template.add(new GrecPoint(8.0, 13.0, 10.0));
		template.add(new GrecPoint(9.0, 12.0, 10.0));
		template.add(new GrecPoint(10.0, 12.0, 11.0));
		template.add(new GrecPoint(11.0, 11.0, 11.0));
		template.add(new GrecPoint(12.0, 10.0, 11.0));
		template.add(new GrecPoint(13.0, 9.0, 11.0));
		template.add(new GrecPoint(14.0, 8.0, 11.0));
		template.add(new GrecPoint(15.0, 7.0, 11.0));
		template.add(new GrecPoint(16.0, 6.0, 11.0));
		template.add(new GrecPoint(17.0, 5.0, 11.0));
		template.add(new GrecPoint(18.0, 4.0, 10.0));
		template.add(new GrecPoint(19.0, 3.0, 10.0));
		template.add(new GrecPoint(20.0, 2.0, 10.0));
		template.add(new GrecPoint(21.0, 2.0, 9.0));
		template.add(new GrecPoint(22.0, 1.0, 9.0));
		template.add(new GrecPoint(23.0, 1.0, 8.0));
		template.add(new GrecPoint(24.0, 0.0, 8.0));
		template.add(new GrecPoint(25.0, 0.0, 7.0));
		template.add(new GrecPoint(26.0, 0.0, 6.0));
		template.add(new GrecPoint(27.0, 0.0, 5.0));
		template.add(new GrecPoint(28.0, 1.0, 5.0));
		template.add(new GrecPoint(29.0, 1.0, 4.0));
		templates.put(new String[]{"circle_cw6",Constants.CIRCLE_CW}, template);

		template = new ArrayList<GrecPoint>();
		template.add(new GrecPoint(0.0, 12.0, 15.0));
		template.add(new GrecPoint(1.0, 11.0, 15.0));
		template.add(new GrecPoint(2.0, 10.0, 15.0));
		template.add(new GrecPoint(3.0, 9.0, 15.0));
		template.add(new GrecPoint(4.0, 8.0, 15.0));
		template.add(new GrecPoint(5.0, 7.0, 15.0));
		template.add(new GrecPoint(6.0, 7.0, 14.0));
		template.add(new GrecPoint(7.0, 6.0, 14.0));
		template.add(new GrecPoint(8.0, 5.0, 14.0));
		template.add(new GrecPoint(9.0, 5.0, 13.0));
		template.add(new GrecPoint(10.0, 4.0, 13.0));
		template.add(new GrecPoint(11.0, 4.0, 12.0));
		template.add(new GrecPoint(12.0, 3.0, 11.0));
		template.add(new GrecPoint(13.0, 3.0, 10.0));
		template.add(new GrecPoint(14.0, 3.0, 9.0));
		template.add(new GrecPoint(15.0, 4.0, 8.0));
		template.add(new GrecPoint(16.0, 4.0, 7.0));
		template.add(new GrecPoint(17.0, 4.0, 6.0));
		template.add(new GrecPoint(18.0, 4.0, 5.0));
		template.add(new GrecPoint(19.0, 5.0, 5.0));
		template.add(new GrecPoint(20.0, 5.0, 4.0));
		template.add(new GrecPoint(21.0, 5.0, 3.0));
		template.add(new GrecPoint(22.0, 6.0, 3.0));
		template.add(new GrecPoint(23.0, 6.0, 2.0));
		template.add(new GrecPoint(24.0, 6.0, 1.0));
		template.add(new GrecPoint(25.0, 7.0, 1.0));
		template.add(new GrecPoint(26.0, 7.0, 0.0));
		template.add(new GrecPoint(27.0, 8.0, 0.0));
		template.add(new GrecPoint(28.0, 9.0, 0.0));
		template.add(new GrecPoint(29.0, 10.0, 0.0));
		template.add(new GrecPoint(30.0, 11.0, 0.0));
		template.add(new GrecPoint(31.0, 12.0, 0.0));
		templates.put(new String[]{"circle_cw7",Constants.CIRCLE_CW}, template);

		template = new ArrayList<GrecPoint>();
		template.add(new GrecPoint(0.0, 0.0, 11.0));
		template.add(new GrecPoint(1.0, 0.0, 10.0));
		template.add(new GrecPoint(2.0, 0.0, 9.0));
		template.add(new GrecPoint(3.0, 1.0, 9.0));
		template.add(new GrecPoint(4.0, 1.0, 8.0));
		template.add(new GrecPoint(5.0, 1.0, 7.0));
		template.add(new GrecPoint(6.0, 2.0, 7.0));
		template.add(new GrecPoint(7.0, 2.0, 6.0));
		template.add(new GrecPoint(8.0, 3.0, 6.0));
		template.add(new GrecPoint(9.0, 4.0, 6.0));
		template.add(new GrecPoint(10.0, 4.0, 5.0));
		template.add(new GrecPoint(11.0, 5.0, 5.0));
		template.add(new GrecPoint(12.0, 6.0, 5.0));
		template.add(new GrecPoint(13.0, 7.0, 5.0));
		template.add(new GrecPoint(14.0, 8.0, 5.0));
		template.add(new GrecPoint(15.0, 9.0, 5.0));
		template.add(new GrecPoint(16.0, 10.0, 5.0));
		template.add(new GrecPoint(17.0, 10.0, 6.0));
		template.add(new GrecPoint(18.0, 11.0, 6.0));
		template.add(new GrecPoint(19.0, 12.0, 6.0));
		template.add(new GrecPoint(20.0, 12.0, 7.0));
		template.add(new GrecPoint(21.0, 13.0, 7.0));
		template.add(new GrecPoint(22.0, 13.0, 8.0));
		template.add(new GrecPoint(23.0, 14.0, 8.0));
		template.add(new GrecPoint(24.0, 14.0, 9.0));
		template.add(new GrecPoint(25.0, 14.0, 10.0));
		template.add(new GrecPoint(26.0, 15.0, 10.0));
		template.add(new GrecPoint(27.0, 15.0, 11.0));
		template.add(new GrecPoint(28.0, 15.0, 12.0));
		templates.put(new String[]{"circle_cw8",Constants.CIRCLE_CW}, template);

		List<GrecPoint> templateCCW = new ArrayList<GrecPoint>();
		templateCCW.add(new GrecPoint(0.0, 9.0, 2.0));
		templateCCW.add(new GrecPoint(1.0, 8.0, 2.0));
		templateCCW.add(new GrecPoint(2.0, 7.0, 2.0));
		templateCCW.add(new GrecPoint(3.0, 6.0, 2.0));
		templateCCW.add(new GrecPoint(4.0, 6.0, 3.0));
		templateCCW.add(new GrecPoint(5.0, 5.0, 3.0));
		templateCCW.add(new GrecPoint(6.0, 4.0, 4.0));
		templateCCW.add(new GrecPoint(7.0, 3.0, 5.0));
		templateCCW.add(new GrecPoint(8.0, 2.0, 5.0));
		templateCCW.add(new GrecPoint(9.0, 1.0, 6.0));
		templateCCW.add(new GrecPoint(10.0, 1.0, 7.0));
		templateCCW.add(new GrecPoint(11.0, 0.0, 8.0));
		templateCCW.add(new GrecPoint(12.0, 0.0, 9.0));
		templateCCW.add(new GrecPoint(13.0, 0.0, 10.0));
		templateCCW.add(new GrecPoint(14.0, 0.0, 11.0));
		templateCCW.add(new GrecPoint(15.0, 1.0, 11.0));
		templateCCW.add(new GrecPoint(16.0, 1.0, 12.0));
		templateCCW.add(new GrecPoint(17.0, 2.0, 12.0));
		templateCCW.add(new GrecPoint(18.0, 3.0, 12.0));
		templateCCW.add(new GrecPoint(19.0, 4.0, 12.0));
		templateCCW.add(new GrecPoint(20.0, 4.0, 13.0));
		templateCCW.add(new GrecPoint(21.0, 5.0, 13.0));
		templateCCW.add(new GrecPoint(22.0, 6.0, 13.0));
		templateCCW.add(new GrecPoint(23.0, 7.0, 13.0));
		templateCCW.add(new GrecPoint(24.0, 8.0, 13.0));
		templateCCW.add(new GrecPoint(25.0, 9.0, 13.0));
		templateCCW.add(new GrecPoint(26.0, 10.0, 13.0));
		templateCCW.add(new GrecPoint(27.0, 11.0, 12.0));
		templateCCW.add(new GrecPoint(28.0, 12.0, 12.0));
		templateCCW.add(new GrecPoint(29.0, 13.0, 12.0));
		templateCCW.add(new GrecPoint(30.0, 13.0, 11.0));
		templateCCW.add(new GrecPoint(31.0, 14.0, 11.0));
		templateCCW.add(new GrecPoint(32.0, 14.0, 10.0));
		templateCCW.add(new GrecPoint(33.0, 15.0, 10.0));
		templateCCW.add(new GrecPoint(34.0, 15.0, 9.0));
		templateCCW.add(new GrecPoint(35.0, 15.0, 8.0));
		templateCCW.add(new GrecPoint(36.0, 15.0, 7.0));
		templateCCW.add(new GrecPoint(37.0, 15.0, 6.0));
		templateCCW.add(new GrecPoint(38.0, 14.0, 6.0));
		templateCCW.add(new GrecPoint(39.0, 14.0, 5.0));
		templateCCW.add(new GrecPoint(40.0, 13.0, 4.0));
		templateCCW.add(new GrecPoint(41.0, 12.0, 3.0));
		templateCCW.add(new GrecPoint(42.0, 11.0, 3.0));
		templateCCW.add(new GrecPoint(43.0, 10.0, 3.0));
		templateCCW.add(new GrecPoint(44.0, 9.0, 3.0));
		templateCCW.add(new GrecPoint(45.0, 8.0, 3.0));
		templates.put(new String[]{"circle_ccw1",Constants.CIRCLE_CCW}, templateCCW);

		template = new ArrayList<GrecPoint>();
		template.add(new GrecPoint(0.0, 0.0, 8.0));
		template.add(new GrecPoint(1.0, 0.0, 9.0));
		template.add(new GrecPoint(2.0, 0.0, 10.0));
		template.add(new GrecPoint(3.0, 0.0, 11.0));
		template.add(new GrecPoint(4.0, 1.0, 11.0));
		template.add(new GrecPoint(5.0, 1.0, 12.0));
		template.add(new GrecPoint(6.0, 2.0, 12.0));
		template.add(new GrecPoint(7.0, 2.0, 13.0));
		template.add(new GrecPoint(8.0, 3.0, 13.0));
		template.add(new GrecPoint(9.0, 4.0, 14.0));
		template.add(new GrecPoint(10.0, 5.0, 14.0));
		template.add(new GrecPoint(11.0, 6.0, 14.0));
		template.add(new GrecPoint(12.0, 7.0, 14.0));
		template.add(new GrecPoint(13.0, 8.0, 14.0));
		template.add(new GrecPoint(14.0, 9.0, 13.0));
		template.add(new GrecPoint(15.0, 10.0, 13.0));
		template.add(new GrecPoint(16.0, 11.0, 13.0));
		template.add(new GrecPoint(17.0, 12.0, 12.0));
		template.add(new GrecPoint(18.0, 13.0, 12.0));
		template.add(new GrecPoint(19.0, 13.0, 11.0));
		template.add(new GrecPoint(20.0, 14.0, 11.0));
		template.add(new GrecPoint(21.0, 14.0, 10.0));
		template.add(new GrecPoint(22.0, 14.0, 9.0));
		template.add(new GrecPoint(23.0, 15.0, 9.0));
		template.add(new GrecPoint(24.0, 15.0, 8.0));
		template.add(new GrecPoint(25.0, 15.0, 7.0));
		template.add(new GrecPoint(26.0, 15.0, 6.0));
		template.add(new GrecPoint(27.0, 15.0, 5.0));
		template.add(new GrecPoint(28.0, 14.0, 5.0));
		template.add(new GrecPoint(29.0, 14.0, 4.0));
		template.add(new GrecPoint(30.0, 14.0, 3.0));
		template.add(new GrecPoint(31.0, 13.0, 3.0));
		template.add(new GrecPoint(32.0, 13.0, 2.0));
		template.add(new GrecPoint(33.0, 12.0, 2.0));
		template.add(new GrecPoint(34.0, 11.0, 2.0));
		template.add(new GrecPoint(35.0, 10.0, 2.0));
		template.add(new GrecPoint(36.0, 9.0, 2.0));
		template.add(new GrecPoint(37.0, 8.0, 2.0));
		template.add(new GrecPoint(38.0, 7.0, 2.0));
		template.add(new GrecPoint(39.0, 6.0, 3.0));
		template.add(new GrecPoint(40.0, 5.0, 3.0));
		template.add(new GrecPoint(41.0, 4.0, 3.0));
		template.add(new GrecPoint(42.0, 4.0, 4.0));
		template.add(new GrecPoint(43.0, 3.0, 4.0));
		template.add(new GrecPoint(44.0, 3.0, 5.0));
		template.add(new GrecPoint(45.0, 2.0, 5.0));
		template.add(new GrecPoint(46.0, 2.0, 6.0));
		template.add(new GrecPoint(47.0, 2.0, 7.0));
		template.add(new GrecPoint(48.0, 1.0, 7.0));
		templates.put(new String[]{"circle_ccw2",Constants.CIRCLE_CCW}, template);

		template = new ArrayList<GrecPoint>();
		template.add(new GrecPoint(0.0, 5.0, 13.0));
		template.add(new GrecPoint(1.0, 6.0, 13.0));
		template.add(new GrecPoint(2.0, 7.0, 13.0));
		template.add(new GrecPoint(3.0, 8.0, 12.0));
		template.add(new GrecPoint(4.0, 9.0, 12.0));
		template.add(new GrecPoint(5.0, 10.0, 12.0));
		template.add(new GrecPoint(6.0, 11.0, 12.0));
		template.add(new GrecPoint(7.0, 12.0, 11.0));
		template.add(new GrecPoint(8.0, 13.0, 11.0));
		template.add(new GrecPoint(9.0, 13.0, 10.0));
		template.add(new GrecPoint(10.0, 14.0, 10.0));
		template.add(new GrecPoint(11.0, 14.0, 9.0));
		template.add(new GrecPoint(12.0, 15.0, 9.0));
		template.add(new GrecPoint(13.0, 15.0, 8.0));
		template.add(new GrecPoint(14.0, 15.0, 7.0));
		template.add(new GrecPoint(15.0, 15.0, 6.0));
		template.add(new GrecPoint(16.0, 14.0, 5.0));
		template.add(new GrecPoint(17.0, 14.0, 4.0));
		template.add(new GrecPoint(18.0, 13.0, 4.0));
		template.add(new GrecPoint(19.0, 13.0, 3.0));
		template.add(new GrecPoint(20.0, 12.0, 3.0));
		template.add(new GrecPoint(21.0, 11.0, 3.0));
		template.add(new GrecPoint(22.0, 11.0, 2.0));
		template.add(new GrecPoint(23.0, 10.0, 2.0));
		template.add(new GrecPoint(24.0, 9.0, 2.0));
		template.add(new GrecPoint(25.0, 8.0, 2.0));
		template.add(new GrecPoint(26.0, 7.0, 2.0));
		template.add(new GrecPoint(27.0, 6.0, 2.0));
		template.add(new GrecPoint(28.0, 5.0, 2.0));
		template.add(new GrecPoint(29.0, 4.0, 2.0));
		template.add(new GrecPoint(30.0, 4.0, 3.0));
		template.add(new GrecPoint(31.0, 3.0, 3.0));
		template.add(new GrecPoint(32.0, 2.0, 3.0));
		template.add(new GrecPoint(33.0, 1.0, 4.0));
		template.add(new GrecPoint(34.0, 0.0, 5.0));
		template.add(new GrecPoint(35.0, 0.0, 6.0));
		template.add(new GrecPoint(36.0, 0.0, 7.0));
		template.add(new GrecPoint(37.0, 0.0, 8.0));
		template.add(new GrecPoint(38.0, 0.0, 9.0));
		template.add(new GrecPoint(39.0, 0.0, 10.0));
		template.add(new GrecPoint(40.0, 1.0, 10.0));
		template.add(new GrecPoint(41.0, 1.0, 11.0));
		template.add(new GrecPoint(42.0, 2.0, 12.0));
		template.add(new GrecPoint(43.0, 3.0, 12.0));
		template.add(new GrecPoint(44.0, 4.0, 12.0));
		template.add(new GrecPoint(45.0, 4.0, 13.0));
		template.add(new GrecPoint(46.0, 5.0, 13.0));
		template.add(new GrecPoint(47.0, 6.0, 13.0));
		template.add(new GrecPoint(48.0, 6.0, 12.0));
		templates.put(new String[]{"circle_ccw3",Constants.CIRCLE_CCW}, template);

		template = new ArrayList<GrecPoint>();
		template.add(new GrecPoint(0.0, 15.0, 9.0));
		template.add(new GrecPoint(1.0, 15.0, 8.0));
		template.add(new GrecPoint(2.0, 15.0, 7.0));
		template.add(new GrecPoint(3.0, 15.0, 6.0));
		template.add(new GrecPoint(4.0, 14.0, 6.0));
		template.add(new GrecPoint(5.0, 14.0, 5.0));
		template.add(new GrecPoint(6.0, 14.0, 4.0));
		template.add(new GrecPoint(7.0, 13.0, 4.0));
		template.add(new GrecPoint(8.0, 13.0, 3.0));
		template.add(new GrecPoint(9.0, 12.0, 3.0));
		template.add(new GrecPoint(10.0, 12.0, 2.0));
		template.add(new GrecPoint(11.0, 11.0, 2.0));
		template.add(new GrecPoint(12.0, 11.0, 1.0));
		template.add(new GrecPoint(13.0, 10.0, 1.0));
		template.add(new GrecPoint(14.0, 9.0, 1.0));
		template.add(new GrecPoint(15.0, 8.0, 1.0));
		template.add(new GrecPoint(16.0, 7.0, 1.0));
		template.add(new GrecPoint(17.0, 7.0, 2.0));
		template.add(new GrecPoint(18.0, 6.0, 2.0));
		template.add(new GrecPoint(19.0, 5.0, 2.0));
		template.add(new GrecPoint(20.0, 5.0, 3.0));
		template.add(new GrecPoint(21.0, 4.0, 3.0));
		template.add(new GrecPoint(22.0, 3.0, 3.0));
		template.add(new GrecPoint(23.0, 3.0, 4.0));
		template.add(new GrecPoint(24.0, 2.0, 4.0));
		template.add(new GrecPoint(25.0, 2.0, 5.0));
		template.add(new GrecPoint(26.0, 1.0, 5.0));
		template.add(new GrecPoint(27.0, 1.0, 6.0));
		template.add(new GrecPoint(28.0, 0.0, 6.0));
		template.add(new GrecPoint(29.0, 0.0, 7.0));
		template.add(new GrecPoint(30.0, 0.0, 8.0));
		template.add(new GrecPoint(31.0, 0.0, 9.0));
		template.add(new GrecPoint(32.0, 1.0, 9.0));
		template.add(new GrecPoint(33.0, 1.0, 10.0));
		template.add(new GrecPoint(34.0, 1.0, 11.0));
		template.add(new GrecPoint(35.0, 2.0, 11.0));
		template.add(new GrecPoint(36.0, 2.0, 12.0));
		template.add(new GrecPoint(37.0, 3.0, 12.0));
		template.add(new GrecPoint(38.0, 4.0, 12.0));
		template.add(new GrecPoint(39.0, 4.0, 13.0));
		template.add(new GrecPoint(40.0, 5.0, 13.0));
		template.add(new GrecPoint(41.0, 6.0, 13.0));
		template.add(new GrecPoint(42.0, 7.0, 13.0));
		template.add(new GrecPoint(43.0, 8.0, 13.0));
		template.add(new GrecPoint(44.0, 9.0, 13.0));
		template.add(new GrecPoint(45.0, 10.0, 13.0));
		template.add(new GrecPoint(46.0, 10.0, 12.0));
		template.add(new GrecPoint(47.0, 11.0, 12.0));
		template.add(new GrecPoint(48.0, 12.0, 11.0));
		template.add(new GrecPoint(49.0, 12.0, 10.0));
		template.add(new GrecPoint(50.0, 13.0, 10.0));
		template.add(new GrecPoint(51.0, 13.0, 9.0));
		template.add(new GrecPoint(52.0, 14.0, 9.0));
		template.add(new GrecPoint(53.0, 14.0, 8.0));
		templates.put(new String[]{"circle_ccw4",Constants.CIRCLE_CCW}, template);

		template = new ArrayList<GrecPoint>();
		template.add(new GrecPoint(0.0, 15.0, 12.0));
		template.add(new GrecPoint(1.0, 15.0, 11.0));
		template.add(new GrecPoint(2.0, 14.0, 11.0));
		template.add(new GrecPoint(3.0, 14.0, 10.0));
		template.add(new GrecPoint(4.0, 13.0, 9.0));
		template.add(new GrecPoint(5.0, 13.0, 8.0));
		template.add(new GrecPoint(6.0, 12.0, 8.0));
		template.add(new GrecPoint(7.0, 12.0, 7.0));
		template.add(new GrecPoint(8.0, 11.0, 7.0));
		template.add(new GrecPoint(9.0, 10.0, 6.0));
		template.add(new GrecPoint(10.0, 9.0, 6.0));
		template.add(new GrecPoint(11.0, 8.0, 5.0));
		template.add(new GrecPoint(12.0, 7.0, 5.0));
		template.add(new GrecPoint(13.0, 6.0, 5.0));
		template.add(new GrecPoint(14.0, 5.0, 5.0));
		template.add(new GrecPoint(15.0, 4.0, 6.0));
		template.add(new GrecPoint(16.0, 3.0, 6.0));
		template.add(new GrecPoint(17.0, 3.0, 7.0));
		template.add(new GrecPoint(18.0, 2.0, 8.0));
		template.add(new GrecPoint(19.0, 2.0, 9.0));
		template.add(new GrecPoint(20.0, 1.0, 9.0));
		template.add(new GrecPoint(21.0, 1.0, 10.0));
		template.add(new GrecPoint(22.0, 0.0, 11.0));
		template.add(new GrecPoint(23.0, 0.0, 12.0));
		templates.put(new String[]{"circle_ccw5",Constants.CIRCLE_CCW}, template);

		template = new ArrayList<GrecPoint>();
		template.add(new GrecPoint(0.0, 11.0, 0.0));
		template.add(new GrecPoint(1.0, 10.0, 0.0));
		template.add(new GrecPoint(2.0, 9.0, 0.0));
		template.add(new GrecPoint(3.0, 8.0, 1.0));
		template.add(new GrecPoint(4.0, 7.0, 1.0));
		template.add(new GrecPoint(5.0, 7.0, 2.0));
		template.add(new GrecPoint(6.0, 7.0, 3.0));
		template.add(new GrecPoint(7.0, 6.0, 3.0));
		template.add(new GrecPoint(8.0, 6.0, 4.0));
		template.add(new GrecPoint(9.0, 5.0, 4.0));
		template.add(new GrecPoint(10.0, 5.0, 5.0));
		template.add(new GrecPoint(11.0, 4.0, 6.0));
		template.add(new GrecPoint(12.0, 4.0, 7.0));
		template.add(new GrecPoint(13.0, 4.0, 8.0));
		template.add(new GrecPoint(14.0, 4.0, 9.0));
		template.add(new GrecPoint(15.0, 5.0, 10.0));
		template.add(new GrecPoint(16.0, 5.0, 11.0));
		template.add(new GrecPoint(17.0, 5.0, 12.0));
		template.add(new GrecPoint(18.0, 6.0, 12.0));
		template.add(new GrecPoint(19.0, 6.0, 13.0));
		template.add(new GrecPoint(20.0, 7.0, 13.0));
		template.add(new GrecPoint(21.0, 7.0, 14.0));
		template.add(new GrecPoint(22.0, 8.0, 14.0));
		template.add(new GrecPoint(23.0, 9.0, 14.0));
		template.add(new GrecPoint(24.0, 9.0, 15.0));
		template.add(new GrecPoint(25.0, 10.0, 15.0));
		template.add(new GrecPoint(26.0, 11.0, 15.0));
		template.add(new GrecPoint(27.0, 12.0, 15.0));
		template.add(new GrecPoint(28.0, 13.0, 15.0));
		templates.put(new String[]{"circle_ccw6",Constants.CIRCLE_CCW}, template);

		template = new ArrayList<GrecPoint>();
		template.add(new GrecPoint(0.0, 0.0, 3.0));
		template.add(new GrecPoint(1.0, 0.0, 4.0));
		template.add(new GrecPoint(2.0, 0.0, 5.0));
		template.add(new GrecPoint(3.0, 1.0, 5.0));
		template.add(new GrecPoint(4.0, 1.0, 6.0));
		template.add(new GrecPoint(5.0, 1.0, 7.0));
		template.add(new GrecPoint(6.0, 2.0, 8.0));
		template.add(new GrecPoint(7.0, 2.0, 9.0));
		template.add(new GrecPoint(8.0, 3.0, 9.0));
		template.add(new GrecPoint(9.0, 4.0, 9.0));
		template.add(new GrecPoint(10.0, 4.0, 10.0));
		template.add(new GrecPoint(11.0, 5.0, 10.0));
		template.add(new GrecPoint(12.0, 6.0, 10.0));
		template.add(new GrecPoint(13.0, 7.0, 10.0));
		template.add(new GrecPoint(14.0, 7.0, 11.0));
		template.add(new GrecPoint(15.0, 8.0, 11.0));
		template.add(new GrecPoint(16.0, 8.0, 10.0));
		template.add(new GrecPoint(17.0, 9.0, 10.0));
		template.add(new GrecPoint(18.0, 10.0, 10.0));
		template.add(new GrecPoint(19.0, 11.0, 10.0));
		template.add(new GrecPoint(20.0, 12.0, 9.0));
		template.add(new GrecPoint(21.0, 13.0, 9.0));
		template.add(new GrecPoint(22.0, 13.0, 8.0));
		template.add(new GrecPoint(23.0, 14.0, 8.0));
		template.add(new GrecPoint(24.0, 14.0, 7.0));
		template.add(new GrecPoint(25.0, 15.0, 7.0));
		template.add(new GrecPoint(26.0, 15.0, 6.0));
		template.add(new GrecPoint(27.0, 15.0, 5.0));
		template.add(new GrecPoint(28.0, 15.0, 4.0));
		template.add(new GrecPoint(29.0, 15.0, 3.0));
		templates.put(new String[]{"circle_ccw7",Constants.CIRCLE_CCW}, template);

		template = new ArrayList<GrecPoint>();
		template.add(new GrecPoint(0.0, 3.0, 15.0));
		template.add(new GrecPoint(1.0, 4.0, 15.0));
		template.add(new GrecPoint(2.0, 5.0, 15.0));
		template.add(new GrecPoint(3.0, 6.0, 15.0));
		template.add(new GrecPoint(4.0, 6.0, 14.0));
		template.add(new GrecPoint(5.0, 7.0, 14.0));
		template.add(new GrecPoint(6.0, 8.0, 14.0));
		template.add(new GrecPoint(7.0, 8.0, 13.0));
		template.add(new GrecPoint(8.0, 9.0, 13.0));
		template.add(new GrecPoint(9.0, 10.0, 12.0));
		template.add(new GrecPoint(10.0, 10.0, 11.0));
		template.add(new GrecPoint(11.0, 10.0, 10.0));
		template.add(new GrecPoint(12.0, 11.0, 10.0));
		template.add(new GrecPoint(13.0, 11.0, 9.0));
		template.add(new GrecPoint(14.0, 11.0, 8.0));
		template.add(new GrecPoint(15.0, 11.0, 7.0));
		template.add(new GrecPoint(16.0, 11.0, 6.0));
		template.add(new GrecPoint(17.0, 11.0, 5.0));
		template.add(new GrecPoint(18.0, 10.0, 4.0));
		template.add(new GrecPoint(19.0, 10.0, 3.0));
		template.add(new GrecPoint(20.0, 10.0, 2.0));
		template.add(new GrecPoint(21.0, 9.0, 2.0));
		template.add(new GrecPoint(22.0, 8.0, 1.0));
		template.add(new GrecPoint(23.0, 7.0, 1.0));
		template.add(new GrecPoint(24.0, 6.0, 1.0));
		template.add(new GrecPoint(25.0, 5.0, 0.0));
		template.add(new GrecPoint(26.0, 4.0, 0.0));
		templates.put(new String[]{"circle_ccw8",Constants.CIRCLE_CCW}, template);

	}

	public static List<double[]> normalizeMesh(List<int[]> points) {
		int minx = 99999;
		int miny = 99999;
		List<double[]> ret = new ArrayList<double[]>();

		for (int[] p : points) {
			if (p[0] < minx) {
				minx = p[0];
			}

			if (p[1] < miny) {
				miny = p[1];
			}

		}
		for (int[] p : points) {
			ret.add(new double[] { p[0] - minx, p[1] - miny });
		}

		return ret;
	}

	public static double[] findCenteroid(List<double[]> points) {

		double centroidX = 0, centroidY = 0;

		for (double[] knot : points) {
			centroidX += knot[0];
			centroidY += knot[1];
		}

		double[] cent = new double[] { centroidX / points.size(),
				centroidY / points.size() };
		return cent;
	}

	public static List<int[]> mapPointsToMash(List<double[]> points,
			int meshResolution, double[] centeroid) {
		List<int[]> ret = new ArrayList<int[]>();
		double maxSize = 0;
		boolean maxX = false;
		for (double[] p : points) {
			if (p[0] > maxSize) {
				maxSize = p[0];
				maxX = true;
			}
			if (p[1] > maxSize) {
				maxSize = p[1];
				maxX = false;
			}
		}

		
		if (maxX) {
			double trans = (maxSize / 2) - centeroid[1];
			
			for (double[] p : points) {
				
				p[1] = p[1] + trans;
				
			}
		} else {
			double trans = (maxSize / 2) - centeroid[0];
			
			for (double[] p : points) {
				
				p[0] = p[0] + trans;
				
			}
		}

		double cell = maxSize / (GrecMesh.resolution - 1);
		
		
		for (double[] p : points) {
			double xm = p[0] / cell;
			long rx = Math.round(xm);
			if (rx < 0) {
				rx = 0;
			}
			if (rx > (GrecMesh.resolution - 1)) {
				rx = GrecMesh.resolution - 1;
			}
			double ym = p[1] / cell;
			long ry = Math.round(ym);
			if (ry < 0) {
				ry = 0;
			}
			if (ry > (GrecMesh.resolution - 1)) {
				ry = GrecMesh.resolution - 1;
			}
			ret.add(new int[] { (int) rx, (int) ry });

		}

		return ret;
	}



}
