package dao;

import java.sql.Connection;

public class FoodDAO 
{
	Connection con;
	private static FoodDAO  foodDAO;
	
	public void setConnection(Connection con)
	{
		this.con = con;
	}
	
	public static FoodDAO  getInstance()
	{
		if(foodDAO == null)
		{
			foodDAO = new FoodDAO ();
		}
		return foodDAO;
	}
}
