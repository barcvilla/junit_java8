package org.ceva.ch02;

import java.util.*;

/**
 * Profile captura respuestas a preguntas relevantes. Por ejemplo una compañia podria
 * preguntar a uno que busca empleo: ¿estas dispuesto a reubicarte?
 * Un Profile para un buscador de empleo podria contener un objeto Answer con el valor
 * true para esa pregunta. Adicionamos un objeto Answer a un Profile mediante el metodo add()
 * en la linea 26
 */
public class Profile
{ 
	   private Map<String,Answer> answers = new HashMap<>();
	   private int score;
	   private String name;

	   public Profile(String name) {
	      this.name = name;
	   }
	   
	   public String getName() {
	      return name;
	   }

	   public void add(Answer answer) { 
	      answers.put(answer.getQuestionText(), answer);
	   }
	   
	   /**
	    * Instancia al objeto Criteria es un simple contenedor de un bloque de criterios
	    * @param criteria
	    * @return
	    */
	   public boolean matches(Criteria criteria) { 
	      score = 0;
	      
	      boolean kill = false;
	      boolean anyMatches = false; 
	      /**
	       * Un Criterion representa lo que el empleador busca en el candidato o empleado
	       * o vice versa. Este encapsula un objeto Answer y un objeto Weight, los cuales
	       * representan cuan importante es la respuesta correcta a la pregunta.
	       */
	      for (Criterion criterion: criteria) 
	      {  
	    	 /**
	    	  * En objeto Answer hace referencia al objeto Question
	    	  * correspondiente y contiene un valor apropiado para la respuesta
	    	  */
	         Answer answer = answers.get(
	               criterion.getAnswer().getQuestionText()); 
	         boolean match = 
	               criterion.getWeight() == Weight.DontCare || 
	               answer.match(criterion.getAnswer());

	         if (!match && criterion.getWeight() == Weight.MustMatch) {  
	            kill = true;
	         }
	         if (match) {         
	            score += criterion.getWeight().getValue();
	         }
	         anyMatches |= match;  
	      }
	      if (kill)       
	         return false;
	      return anyMatches; 
	   }

	   public int score() {
	      return score;
	   }
	}
