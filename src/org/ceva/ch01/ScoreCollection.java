package org.ceva.ch01;

import java.util.ArrayList;
import java.util.List;

public class ScoreCollection 
{
	private List<Scoreable> scores = new ArrayList<>();
	
	public void add(Scoreable scoreable)
	{
		scores.add(scoreable);
	}
	
	/*
	 * Metodo que suma el contenido del objeto score y la suma se divido por 2
	 */
	public int arithmeticMean()
	{
		int total = scores.stream().mapToInt(Scoreable::getScore).sum();
		return total / scores.size();
	}
}
