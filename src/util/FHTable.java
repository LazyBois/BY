package util;

import java.util.*;

public class FHTable
{
	private Map<String,node> m;

	public FHTable()
	{
		 m = new HashMap<String,node>();
	}

 	public void add(String N,String T)
	{
		m.put(N, new node(T));
	}
 	
 	public void add(String N,node n)
	{
		m.put(N,n);
	}
	public void set(String k1,String k2)
	{
		node n = m.get(k1);
		m.remove(k1);
		m.put(k2, n);
	}
	public node get(String k)
	{
		return m.get(k);
	}
 	public void remove(String name)
 	{
 		m.remove(name);
 	}
 	
 	public boolean has(String name)
 	{
 		return m.containsKey(name);
 	}
}