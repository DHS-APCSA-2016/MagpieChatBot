import java.util.Random;
import java.io.*;
import java.text.*;

public class Magpie4
{
    /**
     * Get a default greeting   
     * @return a greeting
     */ 
    public String getGreeting()
    {
        return "Hello, let's talk.";
    }

    String[] keywords = {"newton","second law",
            "first law","third law",
            "ap","mechanics","flux","momentum",
            "velocity","acceleration","position",
            "torque","moment","inertia","force",
            "dipole","maxwell","electricity","capacitor",
            "inductor","ampere's law","faraday's law",
            "pendulum","period","oscillation","normal force",
            "gravity","calculus","derivative","integral",
            "kinematics","gravitation","coloumb's law","charge", "hello", "bye"};
    String[] responses = {"The newton (symbol: N) is the International System of Units (SI) derived unit of force. It is named after Isaac Newton in recognition of his work on classical mechanics, specifically Newton's second law of motion.",
            "Newton's second law of motion can be formally stated as follows: The acceleration of an object as produced by a net force is directly proportional to the magnitude of the net force, in the same direction as the net force, and inversely proportional to the mass of the object.",
            "Newton's first lawof motion - sometimes referred to as the lawof inertia. Newton's first law of motion is often stated as. An object at rest stays at rest and an object in motion stays in motion with the same speed and in the same direction unless acted upon by an unbalanced force.",
            "For every force there is a reaction force that is equal in size, but opposite in direction. That is to say that whenever an object pushes another object it gets pushed back in the opposite direction equally hard.",
            "The AP cirriculum for physics involves for 4 exams: AP Physics 1, AP Physics 2, AP Physics C: Mechanics, and AP Physics C: Electricity and Magnetism. The last two examinations are calculus based, whereas the first two are concept-based. All exams are survey introductory physics courses.",
            "The branch of physics that deals with the motion of material objects. The term mechanics generally refers to the motion of large objects, whereas the study of motion at the level of the atom or smaller is the domain of quantum mechanics.",
            "Flux is the amount of ?something? (electric field, bananas, whatever you want) passing through a surface. The total flux depends on strength of the field, the size of the surface it passes through, and their orientation.",
            "Momentum is a commonly used term in sports. A team that has the momentum is on the move and is going to take some effort to stop. A team that has a lot of momentum is really on the move and is going to be hard to stop. Momentum is a physics term; it refers to the quantity of motion that an object has. A sports team that is on the move has the momentum. If an object is in motion (on the move) then it has momentum.",
            "Velocity is a vector quantity that refers to 'the rate at which an object changes its position.' Imagine a person moving rapidly - one step forward and one step back - always returning to the original starting position. While this might result in a frenzy of activity, it would result in a zero velocity. Because the person always returns to the original position, the motion would never result in a change in position. Since velocity is defined as the rate at which the position changes, this motion results in zero velocity. If a person in motion wishes to maximize their velocity, then that person must make every effort to maximize the amount that they are displaced from their original position. Every step must go into moving that person further from where he or she started. For certain, the person should never change directions and begin to return to the starting position.",
            "Acceleration is the rate of change of velocity of an object. where a is acceleration, v is the final velocity of the object, u is the initial velocity of the object and t is the time that has elapsed. This equation can be rearranged to give: v = u + at.",
            "Displacement is defined as the distance, in any direction, of an object relative to the position of another object. Physicists use the concept of a position vector as a graphical tool to visualize displacements. A position vector expresses the position of an object from the origin of a coordinate system.",
            "Torque is the twisting force that tends to cause rotation. The point where the object rotates is known as the axis of rotation. Mathematically torque can be written as T = F * r * sin(theta), and it has units of Newton-meters. When the sum of all torques acting on an object equals zero, it is in rotational equilibrium.",
            "Moments are usually defined with respect to a fixed reference point; they deal with physical quantities as measured at some distance from that reference point. For example, the moment of force acting on an object, often called torque, is the product of the force and the distance from a reference point.",
            "Inertia is the resistance of any physical object to any change in its state of motion; this includes changes to its speed, direction or state of rest. It is the tendency of objects to keep moving in a straight line at constant velocity.",
            "In physics, something that causes a change in the motion of an object. The modern definition of force (an object's mass multiplied by its acceleration) was given by Isaac Newton in Newton's laws of motion. The most familiar unit of force is the pound.",
            "An electric dipole is a separation of positive and negative charges. The simplest example of this is a pair of electric charges of equal magnitude but opposite sign, separated by some (usually small) distance. A permanent electric dipole is called an electret.",
            "Maxwell's equations describe how electric charges and electric currents create electric and magnetic fields. Further, they describe how an electric field can generate a magnetic field, and vice versa. The first equation allows you to calculate the electric field created by a charge. The second allows you to calculate the magnetic field. The other two describe how fields 'circulate' around their sources. Magnetic fields 'circulate' around electric currents and time varying electric fields, AmpŠre's law with Maxwell's correction, while electric fields 'circulate' around time varying magnetic fields, Faraday's law.",
            "Electricity is the set of physical phenomena associated with the presence and flow of electric charge. Electricity gives a wide variety of well-known effects, such as lightning, static electricity, electromagnetic induction and electric current.",
            "An ideal capacitor is characterized by a single constant value, its capacitance. Capacitance is defined as the ratio of the electric charge Q on each conductor to the potential difference V between them. The SI unit of capacitance is the farad (F), which is equal to one coulomb per volt (1 C/V).",
            "An inductor, also called a coil or reactor, is a passive two-terminal electrical component which resists changes in electric current passing through it. It consists of a conductor such as a wire, usually wound into a coil. Energy is stored in a magnetic field in the coil as long as current flows.",
            "Ampere's Law, specifically, says that the magnetic field created by an electric current is proportional to the size of that electric current with a constant of proportionality equal to the permeability of free space. Stationary charges produce electric fields proportional to the magnitude of the charge.",
            "Faraday's law of induction is a basic law of electromagnetism predicting how a magnetic field will interact with an electric circuit to produce an electromotive force (EMF)?a phenomenon called electromagnetic induction.",
            "A pendulum is a weight suspended from a pivot so that it can swing freely. When a pendulum is displaced sideways from its resting, equilibrium position, it is subject to a restoring force due to gravity that will accelerate it back toward the equilibrium position.",
            "A period T is the time needed for one complete cycle of vibration to pass a given point. As the frequency of a wave increases, the period of the wave decreases. Frequency and Period are in a reciprocal relationship that can be expressed mathematically as: Period equals the Total time divided by the Number of cycles.",
            "An oscillation can be a periodic motion that repeats itself in a regular cycle, such as a sine wave, the side to side swing of a pendulum, or the up and down motion of a spring with a weight.",
            "The normal force is the support force exerted upon an object that is in contact with another stable object. For example, if a book is resting upon a surface, then the surface is exerting an upward force upon the book in order to support the weight of the book.",
            "Gravity is the force of attraction between all masses in the universe; especially the attraction of the earth's mass for bodies near its surface.",
            "The branch of mathematics that deals with the finding and properties of derivatives and integrals of functions, by methods originally based on the summation of infinitesimal differences. The two main types are differential calculus and integral calculus.",
            "A function which gives the slope of a curve; that is, the slope of the line tangent to a function. The derivative of a function f at a point x is commonly written f '(x).",
            "A function of which a given function is the derivative, i.e., which yields that function when differentiated, and which may express the area under the curve of a graph of the function.",
            "The branch of mechanics concerned with the motion of objects without reference to the forces that cause the motion.",
            "the force of attraction between all masses in the universe; especially the attraction of the earth's mass for bodies near its surface",
            "Coulomb's law states that: The magnitude of the electrostatic force of interaction between two point charges is directly proportional to the scalar multiplication of the magnitudes of charges and inversely proportional to the square of the distance between them. The force is along the straight line joining them.",
            "In physics, charge, also known as electric charge, electrical charge, or electrostatic charge and symbolized q, is a characteristic of a unit of matter that expresses the extent to which it has more or fewer electrons than protons.",
             "Hello! Welcome to the physics chatbot! Ask me any question and I can help you!",
             "Hello! Welcome to the physics chatbot! Ask me any question and I can help you!",
             "Thank you for using the physics bot! Goodbye!",
            "That question is unfortunately not in my database. Please refer to google.com.",
            "Welcome to the Physics chatbot! I will try my best to answer all of your questions.",
        };
        String[] randresp = {
            "Good assertion!",
            "I am unable to answer that.",
            "Did you know that Newton's second law states that F = ma?",
            "Do you know the name of the first electricity detective? Sherlock Ohms!!! HAHAHA",
            "Busy at the moment.",
            "Please try again later.",
             "Hello! Welcome to the physics chatbot! Ask me any question and I can help you!","Servers are currently down to reach the online database. Please try again.",
            "An error has occured. Please retry."};
        
        Random rand = new Random();

    public String getResponse(String statement)
    {
        String response = null;
        for(int i = 0; i < keywords.length; i++)
        {
            if(findKeyword(statement, keywords[i]) >= 0){
                int value = i;
                response = responses[value];
            }
        }
        if(response == null){
            int a = rand.nextInt(randresp.length);
            response = randresp[a];
        }
        if(findKeyword(statement, "derivCalc") >= 0){
            try
	{
	    BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
	    DecimalFormat df = new DecimalFormat ("#.####");
	    System.out.print ("Enter the highest degree of the polynomial: ");
	    int a = Integer.parseInt (br.readLine ());
	    double coefficient[] = new double [a + 1];
	    double dxdy[] = new double [a];
	    for (int i = 0 ; i <= a ; i++)
	    {
		System.out.print ("Enter number: ");
		coefficient [i] = Double.parseDouble (br.readLine ());
	    }
	    int ce = a;
	    for (int j = 0 ; j < a ; j++)
	    {
		dxdy [j] = coefficient [j] * ce;
		ce--;
	    }
	    System.out.print ("Derivative of Function: ");
	    if (a != 0)
	    {
		for (int k = 0 ; k < a ; k++)
		{
		    System.out.print (df.format (dxdy [k]) + " ");
		}
	    }
	    else
	    {
		System.out.print (0);
	    }
	}
	catch (Exception e)
	{
	    System.exit (0);
	}
        }
        return response;
    }
    
    
 
    /**
     * Take a statement with "I want to <something>." and transform it into 
     * "What would it mean to <something>?"
     * @param statement the user statement, assumed to contain "I want to"
     * @return the transformed statement
     */
    private String transformIWantToStatement(String statement)
    {
        //  Remove the final period, if there is one
        statement = statement.trim();
        String lastChar = statement.substring(statement
                .length() - 1);
        if (lastChar.equals("."))
        {
            statement = statement.substring(0, statement
                .length() - 1);
        }
        int psn = findKeyword (statement, "I want to", 0);
        String restOfStatement = statement.substring(psn + 9).trim();
        return "What would it mean to " + restOfStatement + "?";
    }

    /**
     * Take a statement with "you <something> me" and transform it into 
     * "What makes you think that I <something> you?"
     * @param statement the user statement, assumed to contain "you" followed by "me"
     * @return the transformed statement
     */
    private String transformYouMeStatement(String statement)
    {
        //  Remove the final period, if there is one
        statement = statement.trim();
        String lastChar = statement.substring(statement
                .length() - 1);
        if (lastChar.equals("."))
        {
            statement = statement.substring(0, statement
                .length() - 1);
        }

        int psnOfYou = findKeyword (statement, "you", 0);
        int psnOfMe = findKeyword (statement, "me", psnOfYou + 3);

        String restOfStatement = statement.substring(psnOfYou + 3, psnOfMe).trim();
        return "What makes you think that I " + restOfStatement + " you?";
    }

    /**
     * Search for one word in phrase.  The search is not case sensitive.
     * This method will check that the given goal is not a substring of a longer string
     * (so, for example, "I know" does not contain "no").  
     * @param statement the string to search
     * @param goal the string to search for
     * @param startPos the character of the string to begin the search at
     * @return the index of the first occurrence of goal in statement or -1 if it's not found
     */
    private int findKeyword(String statement, String goal, int startPos)
    {
        String phrase = statement.trim();
        //  The only change to incorporate the startPos is in the line below
        int psn = phrase.toLowerCase().indexOf(goal.toLowerCase(), startPos);

        //  Refinement--make sure the goal isn't part of a word 
        while (psn >= 0) 
        {
            //  Find the string of length 1 before and after the word
            String before = " ", after = " "; 
            if (psn > 0)
            {
                before = phrase.substring (psn - 1, psn).toLowerCase();
            }
            if (psn + goal.length() < phrase.length())
            {
                after = phrase.substring(psn + goal.length(), psn + goal.length() + 1).toLowerCase();
            }

            //  If before and after aren't letters, we've found the word
            if (((before.compareTo ("a") < 0 ) || (before.compareTo("z") > 0))  //  before is not a letter
            && ((after.compareTo ("a") < 0 ) || (after.compareTo("z") > 0)))
            {
                return psn;
            }

            //  The last position didn't work, so let's find the next, if there is one.
            psn = phrase.indexOf(goal.toLowerCase(), psn + 1);

        }

        return -1;
    }

    /**
     * Search for one word in phrase.  The search is not case sensitive.
     * This method will check that the given goal is not a substring of a longer string
     * (so, for example, "I know" does not contain "no").  The search begins at the beginning of the string.  
     * @param statement the string to search
     * @param goal the string to search for
     * @return the index of the first occurrence of goal in statement or -1 if it's not found
     */
    private int findKeyword(String statement, String goal)
    {
        return findKeyword (statement, goal, 0);
    }

    /**
     * Pick a default response to use if nothing else fits.
     * @return a non-committal string
     */
    private String getRandomResponse()
    {
        final int NUMBER_OF_RESPONSES = 4;
        double r = Math.random();
        int whichResponse = (int)(r * NUMBER_OF_RESPONSES);
        String response = "";

        if (whichResponse == 0)
        {
            response = "Interesting, tell me more.";
        }
        else if (whichResponse == 1)
        {
            response = "Hmmm.";
        }
        else if (whichResponse == 2)
        {
            response = "Do you really think so?";
        }
        else if (whichResponse == 3)
        {
            response = "You don't say.";
        }

        return response;
    }

}
