package hr.ponge.cubis.grec.model;

public class GrecPoint {
	
	public GrecPoint(double ordinal,double x, double y) {
		this.ordinal=ordinal;
		this.x=x;
		this.y=y;
	}

	private double ordinal;

	private double x;
	
	private double y;

	public double getOrdinal() {
		return ordinal;
	}

	public void setOrdinal(double ordinal) {
		this.ordinal = ordinal;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(ordinal);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(x);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(y);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GrecPoint other = (GrecPoint) obj;
		if (Double.doubleToLongBits(ordinal) != Double
				.doubleToLongBits(other.ordinal))
			return false;
		if (Double.doubleToLongBits(x) != Double.doubleToLongBits(other.x))
			return false;
		if (Double.doubleToLongBits(y) != Double.doubleToLongBits(other.y))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "GrecPoint [ordinal=" + ordinal + ", x=" + x + ", y=" + y + "]";
	}

	
	
	

}
