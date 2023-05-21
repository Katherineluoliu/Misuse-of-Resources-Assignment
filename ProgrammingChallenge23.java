
package programmingchallenge2.pkg3;

//Import all the required java utilities from the Java library
import java.io.File; //Used to read from a file
import java.util.Scanner;//Used to get input or read from a file
import java.io.IOException;//Used to display all exceptions
import java.io.PrintWriter;//Used to write and print into the file
import java.io.FileWriter;//Used to write into the file

//The following java utilities are needed to import images 
import java.awt.FlowLayout;//Used to set the layout of the picture
import java.awt.image.BufferedImage;//Used to read the file through buffered reader
import javax.imageio.ImageIO;//Used to read the image from the files
import javax.swing.ImageIcon;//Used to get the image
import javax.swing.JFrame;//Used to create the outline, the frame
import javax.swing.JLabel;//Used to draw the image

/**
* ProgrammingChallenge23 goes in-depth into the problems of wasting resources.
* It will lead the player to an introduction and later play a game with him/her.
* The game allows the player to reflect upon themselves and learn ways that 
* can help reduce the waste of resources. Throughout the program, it also gives
* facts and statistics on the dangers of lack of resources.
*
* @author  Katherine Luo Liu
* @version 1.0
* @since   2021-11-12 
*/
public class ProgrammingChallenge23 {//Start of class
    
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Declaration of variables
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Make a global variable scanner for all methods to use
    //This way, we don't have to keep declaring the variable in every method
    public static Scanner in = new Scanner (System.in);
    
    //Declare needed variables for the game to use it for the calculation method
    public static int brush_teeth = 0;
    public static int shower =0;
    public static int food_waste = 0;
    public static int carbon_footprint_time = 0;
    
    /**
    * This is the main method and it is used to organize the overall structure 
    * of the program. It also calls upon other methods and takes their return 
    * values for further calculations. The method needs to throw an exception to 
    * make sure that the program will continue to run with errors when importing
    * the pictures into the program
    *
    * @param args is a string array
    * @throws java.io.IOException
    */
    public static void main(String[] args) throws IOException{
        /***************
        *    Title     *
        ****************/
        System.out.println("=====================================================================================================================================================================  ");
        System.out.println("======================================================   W  a  s  t  i  n  g      r  e  s  o  u  r  c  e  s   =======================================================  ");
        System.out.println("=====================================================================================================================================================================  ");
        System.out.println();
        
        //Tell the user to take a look at the poster
        System.out.println("Please take a look at the three pop-up posters to learn more about the different resources that are wasted.\n\n");
        
        //This line of code calls upon the method "poster" with the parameter int foodwaste
        //It outputs a poster about food waste
        poster (2);
        
        //This line of code calls upon the method "poster" with the parameter String waterwaste
        //It outputs a poster about water waste
        poster("hi");
        
        //This line of code calls upon the method "poster" with the parameter boolean carbonfootprint
        //It outputs a poster about food waste
        poster(true);
        
        //Create a 1-D String array to store the return values of the method introAndEnd
        //Assign it with random values first so it doesn't say not declared
        String messages []= {"intro","Statistics and Facts","Solutions", "Conclude"};
        
        //Call the method introAndEnd and store the return values inside message
        messages = introToEnd(messages);
        
        /*****************************
        *        Introduction        *
        ******************************/
        //Output the introduction that is stored in message index 0
        System.out.println(messages[0]);
        
        /*****************************
        *    Facts and Statistics    *
        ******************************/
        //Outputs the message at index 2 that stores the facts and staistics
        System.out.println(messages[1]);
        
        /*****************************
        *            Game            *
        ******************************/
        //The first time the program runs, it will make sure that the game runs at least once
        String play_again = "yes";
        
        //While loop so that if the player wants to play again, keep looping
        while (play_again.equalsIgnoreCase("yes")){
            //Call upon the helper method game so that the game would be outputted.
            //if the player says yes and want to play again, then play_again would 
            //still have the values "yes" and will continue to loop
            game();
            
            //After the game is finished, we ask if they would like to play again
            System.out.print("\nDo you want to play again? Please enter yes or no.  ");

            //the answer to "do you want to play again" would be returned
            play_again = in.nextLine();
            //enter twice because the last entry was a number
            play_again = in.nextLine();
        }
        
        //Conclusding the game
        double [] resources_usedOrWasted = calculations(brush_teeth, shower, food_waste, carbon_footprint_time);
        System.out.println("\n"
                + "////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////"
                + "//////\n//      Through the activity, you have used " +  (double)Math.round(resources_usedOrWasted[0]*100)/100 + " litres of water "
                + "only from showering and brushing your teeth.                           //\n"
                + "//      You have wasted "+ (double)Math.round((resources_usedOrWasted[1]*100)/100) 
                + " grams of food and caused " + (double)Math.round((resources_usedOrWasted[2]*100)/100) + " kg of CO2.                               "
                + "                                    //\n" 
                + "//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////\n");
        
        /*****************************
        *          solutions         *
        ******************************/
        //Output the do-able solutions to the problems
        System.out.println(messages[2]);
        
        /*****************************
        *         Conclusion         *
        ******************************/
        //Output the concluding message that is at index 3 of messages
        System.out.println(messages[3]);
        
        System.out.println("\nThank you for paying attention, I hope you enjoyed the game. See you next time and have a good day!");
    }//End of main method
    
    /**
    * This method is used to store all kinds of messages. As long as they 
    * are String type. It will store them as strings into a 1-D String array 
    * called intro_end to be used in the main method.
    *
    * @param intro_end is used as a storage for the intro and conclusion messages
    * @return intro_end it will store the messages into intro_end then return it
    * @throws java.io.IOException
    */
    public static String[] introToEnd(String [] intro_end)throws IOException{
        //Introduction to the poverty issues
        //Index 0 will store the introduction
        intro_end[0] = "========================================================================\n"
                + "======================= I n t r o d u c t i o n ========================\n"
                + "========================================================================\n"
                + "Food waste: \nThese are foods that are not eaten. Some causes may be storage issues, not being consumed before the expiry "
                + "\nand unfinished dinners that are thrown in the garbage.\n\nWater waste: \nThis term refers to the amount of water that "
                + "is wasted. It can include long showers, unclosed taps, and \nspilled water.\n\nCarbon footprint: \nIt is the amount of "
                + "greenhouse gas emissions that are generated due to our actions. Some examples would be \ndriving the car, wasting food, "
                + "and electricity usage. \n\n";
        
        
        //This part will give some statistic and state the causes
        //Index 1 will store the facts and statistic
        intro_end[1] = "========================================================================\n"
                + "================ S t a t i s t i c t s   &   F a c t s =================\n"
                + "========================================================================\n"
                + "--According to World Wildlife Fund (WWF), 40% of food grown is never eaten. They are either wasted by improper\n"
                + "  storage, overproduction, processing problems or garbaged as leftovers from meals.\n"
                + "--According to the National Zero Waste Council, 2.2 million tonnes of edible food is wasted every year in Canada.\n"
                + "  these wastes create 9.8 million tonnes of CO2 that add to climate change.\n"
                + "--According to Global News, on average, everyone uses about 329 Liters of water every day. 35% on showering, 30% on\n"
                + "  flushing the toilet, 20% on laundry, 10% on cooking and drinking purposes and lastly, 5% on cleaning purposes.\n"
                + "--Global News also mentions that 8 minutes of showering is equal to 9.5L/min of water usage. A full bathtub contains\n"
                + "  about 150 litres of water, this means that 16 minutes of showering uses more water than a bathtub.\n"
                + "--According to the Nature Conservancy, 15 tons of CO2 are created from travelling, 12 tons of CO2 are created at home,\n"
                + "  7 tons of CO2 are created from food, 7 tons of CO2 are created from goods and another 7 tons are created from services.\n"
                + "--According to Project solar UK, 4,645 litres of water are needed per person every day. Due to the need of supplying\n"
                + "  and treating the water, it creates 3.68 million tonnes of Co2 each year.\n\n";
        
        //This part will give some easy-to-fulfill solutions
        //Index 2 will store some suggestions that are able to be completed
        intro_end[2] = "\n\n========================================================================\n"
                + "========== E a s y - t o - f u l f i l l   S o l u t i o n s ===========\n"
                + "========================================================================\n"
                + "Dealing with food--------------------------------------------\n"
                + "--Always plan. Look through the freezer and cupboard to plan the amount of food that can fit inside. \n"
                + "--Keep things fresh by storing them in the right place. Almost all foods can go in the fridge so make space. Freeze\n"
                + "  meat that won't be eaten later in the week. It can last about two weeks in the freezer.\n"
                + "--Don't waste. Use leftovers to make a salad, smoothies, or as a snack. They're not only healthy but can also result\n"
                + "  in the lesser release of Carbon Dioxide into the environment.\n\n"
                + "Dealing with water-------------------------------------------\n"
                + "--Turn off the tap. When scrubbing your hands, after washing the dishes and so on, turn off the tap.\n"
                + "--Take short showers and install water-saving showerheads. These will keep the water usage lower. \n"
                + "--Always check and fix for leakages. Even 6 drops of water a minute can lead to a waste of 1,200litres of water being \n"
                + "  wasted annually.\n\n"
                + "Dealing with carbon footprint--------------------------------\n"
                + "--Turn off the lights. Don't turn them on during the day and use daylight instead. Also, try to use LED lightbulbs\n"
                + "  because they save more energy. \n"
                + "--Unplug electronics that are not currently in use and try to turn off any heaters when not at home.\n"
                + "--Buy necessities with minimum packages so that less garbage is burned in landfills. The process of burning results\n"
                + "  in the release of CO2 into the air.\n\n";
        
        //This part is the conclusion. We specify the reason why it is important to do these thing.
        //Index 3 will store the conclusion/ending
        intro_end[3] = "========================================================================\n"
                + "========================= C o n c l u s i o n ==========================\n"
                + "========================================================================\n"
                + "Wasting resources can lead to human extinction. It can result in higher crime rates because people would need\n"
                + "to steal, rob or kill to provide themselves with food and water. There could be war from country to country \n"
                + "fighting over resources. Wasting electricity can result in a large number of carbon emissions into the earth. Then\n"
                + "it would alter the climate causing a lower amount of production on food resources. Therefore, everyone should try \n"
                + "their best and only use what is needed. Even the small things like turning the lights off during the day would \n"
                + "make a huge difference. Think about it this way, if every household does small things, this would lead to big\n"
                + "changes.\n\n";
        
        //Return the messages that are stored in the array
        return intro_end;
    }
    
    /**
    * This method is used to play the game.
    * It will output the instructions and ask for the user's input to the questions
    * When the user answers the question, their responses will be stored.
    * Then, the stored values would be outputted for the user to realize their use of resources in one day
    */
    public static void game(){
        int temporary = 0;
        brush_teeth = 0;
        shower =0;
        food_waste = 0;
        carbon_footprint_time = 0;
        
        //Explain the game to the user and link it to real life situations
        System.out.println("========================================================================");
        System.out.println("=============================== G a m e ================================");
        System.out.println("========================================================================");
        System.out.println("In this game, you will learn about some actions that can cause resources to be wasted. Some of these actions may include\n"
                + "daily habits. The game is very imaginative, so you will need to use your creative thinking to make many choices. Some choices may\n"
                + "not be smart, but at least it teaches us something new and give us something to reflect upon. Without further ado, let's begin!\n");
        
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //Ask for the amount of water they use in the morning ///////////////////////////////////////////////////////////////////////////////////////////
        System.out.print("  It is almost near Christmas and you plan to host a holiday festival in your house with your three friends. On the morning \n"
                + "of the party, you've finally decided to go shopping. You will need to buy a gift for gift exchange before 7:00 pm for the Christmas\n"
                + "dinner party. First, you got out of your bed and went to brush your teeth. How many minutes did you spend brushing your teeth?\n"
                + "Please enter integers only. ");
        do{//do-while loop to check for the number of minutes used. Can't use less than 1 min to brush your teeth. 
            //store the value from the user in temporary
            temporary = in.nextInt();
            if (temporary>0){//If the temporary value is greater than 0, then store it in brush_teeth
                brush_teeth += temporary;//Store temporary in brush_teeth if the minutes is valid
            }
            else
                System.out.print("Less than 1 min is not enough to brush your teeth. Please re-enter the value. ");
        }while (temporary<0);//Repeat the do-while if the user enters an invalid value
        
        //Used to separate the first part from the second part
        System.out.print("\n");
        
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //Ask them for the number of grams they will cook to see if any are wasted.///////////////////////////////////////////////////////////////////////
        System.out.print("  After brushing your teeth. You've decided to have an easy breakfast before going to the mall. As part of the breakfast, you\n"
                + "have chosen to eat bacon. How many grams would you cook? Please enter the choice in integers only, e.g. 1, 2 or 3.\n"
                + "1)150g  2)500g  3)1kg  ");
        do{//do-while loop to check for the number of choice made. 
            //store the value from the user in temporary
            temporary = in.nextInt();
            if (temporary>0 && temporary<4){//If the temporary value is one of the choices given, then the value would be stored
                if (temporary == 2)//If the second choice was made, 
                    food_waste = 500-150;//The left overs are 500g minus 150 grams.
                else if (temporary==3)
                    food_waste = 1000-150;//the left overs are 1000g which is 1kg minus 150
            }
            else//If the player enters other number, ask them to re-enter again
                System.out.print("Invalid choice. Please re-enter the choice value. ");
        }while (temporary<0 || temporary>3);//Repeat the do-while if the user enters an invalid value
        
        //Used to separate the second part from the third part
        System.out.print("\n");
        
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //Travelling to the mall///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        System.out.print("  After breakfast, you decided to drive to the mall. Approximately how many km does it take you to the mall? If it takes you a few\n"
                + "miles, please round up to 1km. Reminder: Please enter numbers only. ");
        do{//do-while loop to check and store the number of kms travelled
            //store the value from the user in temporary
            temporary = in.nextInt();
            if (temporary>0){//If the temporary value is greater than 0, then store it in carbon_footprint. 
                carbon_footprint_time += temporary;//Store temporary in carbon_footprint_time if the minutes is valid
            }
            else
                System.out.print("There needs to be a minum of 1km. Please re-enter the value. ");
        }while (temporary<0);//Repeat the do-while if the user enters an invalid value
        
        //Used to separate the third part from the fourth part
        System.out.print("\n");
        
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //Buying the gift /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        System.out.print("  When you arrived at the mall, you went to look for the gift. Which gift have you chosen to get? Please enter the choice in \n"
                + "integers only, e.g. 1, 2 or 3.  1)Jeans  2)Smartphone  3)Laptop   ");
        
        //We need to store the items that are packed inside a file. so we need to use a file writer
        try {
            FileWriter writer = new FileWriter( "storeitems.txt", true );
            PrintWriter output = new PrintWriter( writer );
            do{//do-while loop to check for the number of choice made. 
            //store the value from the user in temporary
                temporary = in.nextInt();
                if (temporary>0 && temporary<4){//If the temporary value is one of the choices given, then the value would be stored
                    //Store these values to the text file called storeitems. 
                    //The text file acts like an array, and will be used to calculate the CO2 later in the method called calculations
                    if (temporary==1)
                       output.print("jeans");
                    if (temporary==2)
                        output.print("smartphone");
                    if (temporary==3)
                        output.print("laptop");
                }
                else//If the player enters other number, ask them to re-enter again
                    System.out.print("Invalid choice. Please re-enter the choice value. ");
                //Close the output after using it
                output.close();
            }while (temporary<0 || temporary>3);//Repeat the do-while if the user enters an invalid value
            
            //writer.close();
        }catch ( IOException ioException ) {
            System.err.println( "Java Exception: " + ioException );
        }
        
        //Used to separate the fourth part from the fifth part
        System.out.print("\n");
        
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //Making dinner /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        System.out.print("  You went home after buying the gift and had plenty of time. So you decided to make your three friends some dinner. You went to\n"
               + "the fridge and looked through the food. You've decided to make them a hamburger. Please pick the ingredients that you want in the \n"
               + "burger. 1) Beef(Dairy herd)  2)cheese  3)eggs  4)tomatoes  5)chicken  6)tuna  7)lettuce  8)lentils  9)bread  Please only enter numbers\n"
               + "separate by commas. For example, if you would like bread, chicken and cheese, please enter 8,5,2  ");
        
        //We need to store the items that are packed inside a file. so we need to use a file writer
        try {
            FileWriter writer2 = new FileWriter( "storeitems.txt", true );
            PrintWriter output2 = new PrintWriter( writer2 );
            do{//do-while loop to check for the number of choices made. 
                //store the values from the user in temporary_word
                //Store it two times because the last value was getting an integer. 
                String temporary_word = in.nextLine();
                temporary_word = in.nextLine();
                
                //Store the different options into an array for comparison
                String [] ingredients = temporary_word.split(",");
                
                //make a for loop to add ingredients into the file
                for (int i=0; i<ingredients.length; i++){
                    //for (int c=0; c<ingredients.length; c++){
                    //Add the ingredients into the file called storeitems.txt
                    //The text file acts like an array, and will be used to calculate the CO2 later in the method called calculations
                    if ("1".equals(ingredients[i]))
                        output2.print(",beef");//beef is the first option
                    else if ("2".equals(ingredients[i]))
                        output2.print(",cheese");//cheese is the second option
                    else if ("3".equals(ingredients[i]))
                        output2.print(",eggs");//eggs are the third option
                    else if ("4".equals(ingredients[i]))
                        output2.print(",tomatoes");//Tomatoes are the fourth option
                    else if ("5".equals(ingredients[i]))
                        output2.print(",chicken");//chicken is the fifth option
                    else if ("6".equals(ingredients[i]))
                        output2.print(",tuna");//tuna is the sixth option
                    else if ("7".equals(ingredients[i]))
                        output2.print(",lettuce");//lettuce is the seventh option
                    else if ("8".equals(ingredients[i]))
                        output2.print(",lentils");//Lentils are the eighth option
                    else if ("9".equals(ingredients[i]))
                        output2.print(",bread");//bread is the ninth and final option
                }//End of for loop
                //Close the writer2 after writing with it
                writer2.close();
                //Close the output2 after done using it
                output2.close();
            }while (temporary<0 || temporary>3);//Repeat the do-while if the user enters an invalid value
            
        }catch ( IOException ioException ) {//catch the exception
            System.err.println( "Java Exception: " + ioException );
        }
        
        //Used to separate the fourth part from the sixth/last part
        System.out.print("\n");
        
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //Making dinner /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        System.out.print("  After the party is over, you decided to take a shower and sleep early. How long did you shower? Please enter in terms of minutes.\n"
                + "Enter numbers only.  ");
        do{//do-while loop to check for the number of minutes used. Can't use less than 1 min to shower
            //store the value from the user in temporary
            temporary = in.nextInt();
            if (temporary>0){//If the temporary value is greater than 0, then store it in shower
                shower += temporary;//Store temporary in shower if the minutes is valid
            }
            else
                System.out.print("Less than 1 min is not enough to brush your teeth. Please re-enter the value.  ");
        }while (temporary<0);//Repeat the do-while if the user enters an invalid value
        
        System.out.print("\nTHE END ---- ////THANK YOU FOR PLAYING THE GAME////");
    }
    
    /**
    * This is a method used to calculate the resources that are used or wasted. 
    * It calculates food waste, water waste, and carbon footprint used in the game.
    *
    * @param brush_teeth it is the first parameter and it is used to help calculate the amount of water used when brushing the teeth
    * @param shower it is the second parameter and it is used to help calculate the amount of water used when showering
    * @param foodwaste it is the third parameter and it is used to calculate the amount of food that is wasted
    * @param carbon_footprint_time it is the fourth and last parameter used to help calculate the amount of carbon footprint that is used in the game
    * @return a double 2-D array that stores the resources that are used or wasted
    * @throws java.io.IOException needed if the file is not found
    */
    public static double [] calculations(int brush_teeth, int shower, int foodwaste, int carbon_footprint_time)throws IOException{
    //Declare a 1-D int array to store all the calculations
    double[] usedResources = new double [3];
    
    //Index 0 will store the amount of water used
    //Note: On average, a faucet uses about 6 litres of water per minute. 
    //Note: Showers use about 9.3 litres/min
    double usedWater = (brush_teeth*6)+(shower*9.3);
    
    //Index 1 will store the wasted amount of food in grams
    //Note: 150g is enough for one person to eat.
    //Note: Food waste is already calculated so we just have to store it
    double wastedFood = foodwaste;
    
    //Index 3 will store the carbon footprints in kg/CO2
    //Note: 1 liter can go 15km. So 1km = 1/15Liters or 0.6L.
    //Note: Times 2 because the car trip went back and forth
    //Note: Remeber to convert 1L of gas = 2.3kg of CO2 
    double carbonFootprintOnTravel = ( (1*(0.6))*2 ) * 2.3;
    
    //To get the carbonFootprint of the items and ingredients, read from the 
    //storeitem.txt file and compare it with the carbonFootprintList.txt 
    String [] storage = {};//This stores the food and gift options that are picked by the player
    String [] finding = {};//This find the corresponding carbon footprint which those items
    String output;//Helps to read from storeietms.txt
    String output2;//Helps to read from carbonFootprintList
    
    //Make a variable to store the carbon footprint after comparing storage and finding
    double carbonFootprintOnItems = 0;
    
    try {//Start of try
        Scanner fileInput = new Scanner(new File("storeitems.txt"));//Use a scanner to read from storeitems.txt
        while ( fileInput.hasNext() ) {//if storeitems.txt has a value...
           output = fileInput.nextLine();//store it in output
           storage = output.split(",");//split it when there is a comma and store it in storage
        }
        fileInput.close();//Close the scanner called fileInout after done using it
    }catch ( IOException ioException ) {//Catch the errors
      System.err.println( "Java Exception: " + ioException);//Output the errors if there are any
    }//End of catch
    
    try {//Start of try
        Scanner fileInput2 = new Scanner(new File("carbonFootprintList.txt"));//Use a scanner to reaf from carbonFootprint.txt
        while ( fileInput2.hasNext() ) {//while there is a value in the text file...
          output2 = fileInput2.nextLine();//store the line in output2
          finding = output2.split(",");//Split the line of output when there is a comma and store it in finding
          
            //For loop used to compare storeitems.txt with crbonFootprint.txt
            //If the two values are the same, it means that the user have picked 
            //the item. So, add it to the variable that stores the carbon footprint
            //For all possible possibilities, use a nested for loop
            for (int r=0; r<storage.length; r++){//The first loop is to check for every storage value
              for (int c=0; c<finding.length; c++){//The second loop is to check for every finding value
                  if (storage[r].equalsIgnoreCase(finding[c]))//If storage equals finding's value...
                  carbonFootprintOnItems += Double.parseDouble(finding[c+1]);//then store the coresponding carbon footprint
                  //Since the file has it in a way that the name is followed by the value, we have to add by 1
                  //For example, the file looks like beef, 27. If beef was picked, the value of beef would be 27 which is c+1
              }//End of the second for loop
            }//End of the first for loop
        }//End of while loop
        fileInput2.close();//Close the scanner called fileInput2 after finish using it
    }catch ( IOException ioException ) {//Catch the errors
      System.err.println( "Java Exception: " + ioException);//Output the errors
    }//End of catch
    
    //find String and string+1
    double carbonFootprint = carbonFootprintOnTravel + carbonFootprintOnItems ;
    
    //Store the appropriate resources in the array to be returned
    usedResources [0] = usedWater;//index 0 for the amount of water used
    usedResources [1] = wastedFood;//index 1 for the amount of food wasted
    usedResources [2] = carbonFootprint;//index 2 for the amount of carbon footprint caused
    
    //return the array to be used in the main method
    return usedResources;
    }
    
    /**
    * This is an overloaded method used to output the poster about food waste
    * It reads the file/image through a buffered reader, then outputs the image.
    *
    * @param foodwaste is used as an identifier to separate itself with the 
    * other two overloaded methods. So when it calls upon poster and enters an 
    * integer, it will output the food waste poster.
    * @throws java.io.IOException
    */
    public static void poster(int foodwaste) throws IOException{
        //Make a picture frame with the name "frame" 
        //It is used to store the image
        JFrame frame = new JFrame();
        
        //Extract the image with an address using the buffered reader. Read it with Image.IO.read()
        BufferedImage img = ImageIO.read(new File("f:/ICS - Gr. 12/ProgrammingChallenge2-3//FoodWaste.png"));
        
        //Set the layout to print it's own size 
        //Don't adjust the size so that the pictue will not be blurry
        frame.getContentPane().setLayout(new FlowLayout());
        frame.getContentPane().add(new JLabel(new ImageIcon(img)));
        
        //Pack up the picture and output it in a new tab
        frame.pack();
        
        //Set the picture to be visible so that the picture can be displayed
        frame.setVisible(true);
     }
    
    /**
    * This is an overloaded method used to output the poster about water waste
    * It reads the file/image through a buffered reader, then output the image.
    *
    * @param waterwaste is used as an identifier to separate itself with the 
    * other two overloaded methods. So when it calls upon poster and enters a 
    * string value, it will output the water waste poster.
    * @throws java.io.IOException
    */
    public static void poster(String waterwaste) throws IOException{
        //Make a picture frame with the name "frame" 
        //It is used to store the image
        JFrame frame = new JFrame();
        
        //Extract the image with an address using the buffered reader. Read it with Image.IO.read()
        BufferedImage img2 = ImageIO.read(new File("f:/ICS - Gr. 12/ProgrammingChallenge2-3//WaterWaste.png"));
        
        //Set the layout to print it's own size 
        //Don't adjust the size so that the pictue will not be blurry
        frame.getContentPane().setLayout(new FlowLayout());
        frame.getContentPane().add(new JLabel(new ImageIcon(img2)));
        
        //Pack up the picture and output it in a new tab
        frame.pack();
        
        //Set the picture to be visible so that the picture can be displayed
        frame.setVisible(true);
     }
    
    /**
    * This is an overloaded method used to output the poster about food waste
    * It reads the file/image through a buffered reader, then output the image.
    *
    * @param carbonfootprint is used as an identifier to separate itself with the 
    * other two overloaded methods. So when it calls upon poster and enters a 
    * boolean value, it will output the carbon footprint poster.
    * @throws java.io.IOException
    */
    public static void poster(boolean carbonfootprint) throws IOException{
        //Make a picture frame with the name "frame" 
        //It is used to store the image
        JFrame frame = new JFrame();
        
        //Extract the image with an address using the buffered reader. Read it with Image.IO.read()
        BufferedImage img3 = ImageIO.read(new File("f:/ICS - Gr. 12/ProgrammingChallenge2-3//CarbonFootprint.png"));
        
        //Set the layout to print it's own size 
        //Don't adjust the size so that the pictue will not be blurry
        frame.getContentPane().setLayout(new FlowLayout());
        frame.getContentPane().add(new JLabel(new ImageIcon(img3)));
        
        //Pack up the picture and output it in a new tab
        frame.pack();
        
        //Set the picture to be visible so that the picture can be displayed
        frame.setVisible(true);
     }
   
}//End of class
