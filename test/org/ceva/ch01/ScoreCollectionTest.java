package org.ceva.ch01;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ScoreCollectionTest 
{
	@Test
	public void answerArithmeticMeanOfTwoNumbers()
	{
		ScoreCollection collection = new ScoreCollection();
		collection.add(() -> 5);
		collection.add(() -> 7);
		
		// actua
		int actualResult = collection.arithmeticMean();
		
		// Assert
		assertThat(actualResult, equalTo(6));
	}

	@Test
	void test() 
	{
		
	}

}
