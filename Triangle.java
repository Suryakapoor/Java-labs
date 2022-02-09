	
public class Triangle {
	
			public static final double DEFAULT_SIDE = 1;
			private double sideA = DEFAULT_SIDE;
			private double sideB = DEFAULT_SIDE;
			private double sideC = DEFAULT_SIDE;
			public static final String POLYGONSHAPE = "Triangle";
	
			public Triangle() {
				sideA = DEFAULT_SIDE;
				sideB = DEFAULT_SIDE;
				sideC = DEFAULT_SIDE;
			}

			public Triangle(double sideA, double sideB, double sideC)
			{
				boolean triangle = isTriangle(sideA, sideB, sideC);

				if (triangle == true)
				{
					this.sideA = sideA;
					this.sideB = sideB;
					this.sideC = sideC;
				}

				else {
					this.sideA = DEFAULT_SIDE;
					this.sideB = DEFAULT_SIDE;
					this.sideC = DEFAULT_SIDE;
				}

			}
			
			public Triangle(double[] sides)
			{
				if (sides != null && (isTriangle(sides)))
				{
					sideA = sides[0];
					sideB = sides[1];
					sideC = sides[2];
				}
				
			}
			
			public Triangle(Triangle triangle)
			{
				if (triangle != null)
				{
					sideA = triangle.getSideA(); 
					sideB = triangle.getSideB(); 
					sideC = triangle.getSideC(); 
				}
						
			}
			
			public double getSideA()
			{
				return sideA;
			}
			
			public double getSideB()
			{
				return sideB;
			}
			
			public double getSideC()
			{
				return sideC;
			}
			
			public double[] getSides()
			{
				double[] sides = new double[3];
				sides[0] = sideA;
				sides[1] = sideB;
				sides[2] = sideC;
				
				return sides;	
			}
			
			public double getAngleA()
			{
				return lawOfCosines(sideB, sideC, sideA);
				
			}
			
			public double getAngleB()
			{
				return lawOfCosines(sideA, sideC, sideB);
				
			}
			
			public double getAngleC()
			{
				return lawOfCosines(sideA, sideB, sideC);
			}
			public double[] getAngles()
			{
				double[] angles = {getAngleA(), getAngleB(), getAngleC()};
				return angles;
				
			}
		
			
			public static double lawOfCosines(double a, double b, double c)
			{
				return Math.toDegrees(Math.acos((Math.pow(c, 2)-Math.pow(a, 2)- Math.pow(b, 2))/(-2*a*b)));
			}
			
			public boolean setSideA(double sideA)
			{
				if (isTriangle(sideA, this.sideB, this.sideC) == true)
				{
					this.sideA = sideA; 
					return true;
				}
				
				return false;
			}
			public boolean setSideB(double sideB)
			{
				if (isTriangle(this.sideA, sideB, this.sideC) == true)
				{
					this.sideB = sideB; 
					return true;
				}
				
				return false; 
			}
			
			public boolean setSideC(double sideC)
			{
				if (isTriangle(this.sideA, this.sideB, sideC) == true)
				{
					this.sideC = sideC; 
					return true;
				}
				
				return false; 
			}
			public boolean setSides(double[] sides)
			{
				if (isTriangle(sides) == true)
				{
					this.sideA = sides[0];
					this.sideB = sides[1];
					this.sideC = sides[2];
					return true;
				}
				return false; 
			}
			
			public static boolean isTriangle(double a, double b, double c) 
			{
				boolean isTriangle = false;

				if ((a > 0 && b > 0 && c > 0) && (a < b + c && b < c + a && c < a + b)) {
					isTriangle = true;
				}

				return isTriangle;
			}

			public static boolean isTriangle(double[] sides)
			{
				if(sides == null || sides.length != 3 )
				{
					return false;
				}
				
				if(sides.length == 3) {
				for (int i = 0; i < 3; ++i)
					{
						if(sides[i] <= 0)
						{
							return false;
						}
					}
				}
				double a = sides[0];
				double b = sides[1];
				double c = sides[2];
				
				if (a >= b + c || b >= c + a || c >= b + a)
				{
					return false;
				}
				
				return true;
			}
			
			public String toString()
			{
				String format = POLYGONSHAPE + "(%.2f, %.2f, %.2f)";
				return String.format(format, sideA, sideB, sideC);
			}
			
			
}





