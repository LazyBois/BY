package util;

import java.util.*;

public class node{

	public String type ;
	public ArrayList<array> v;
	
	public node(String type)
	{
		this.type = type;
		v = new ArrayList<array>();
	}
	public node()
	{
		v = new ArrayList<array>();
	}
	public void setType(String type)
	{
		this.type = type;
	}
	public void add(array a)
	{
		v.add(a);
	}

}