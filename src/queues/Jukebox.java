/**
 * Tuba Siddiqui
 * CS1C
 * manage three objects of type Queue<String>. The class Jukebox manages three objects of type Queue
 */

package queues;

import java.io.*;
import cs1c.*;
import java.util.Scanner;

// Define the class Jukebox such that the constructor reads the file with user's request for
// what the song to add to which playlist.
// Possible valid playlists are "favorites", "lounge" and "road trip",
// called favoritesPL, loungePL and roadTripPL respectively.
// Then accesses the three playlists and sets them to the appropriate class attributes.

/**
 * manages three objects of type Queue
 */
public class Jukebox {

        //Attributes
        //A variable called favoritePL of type Queue<SongEntry> which simulates the
        //playlist referred to as "favorites" in the input file
        /**
         * variable for "favorite" playlist
         */
        private Queue<SongEntry> favoritePL;

        //A variable called roadTripPL of type Queue<SongEntry> which simulates the
        //playlist referred to as "road trip" in the input file.

        /**
         * variable for "road trip" playlist
         */
        private Queue<SongEntry> roadTripPL;

        //A variable called loungePL​ of type Queue<SongEntry> which simulates the
        //playlist referred to as "lounge" in the input file.

        /**
         * variable for "lounge" playlist
         */
        private Queue<SongEntry> loungePL;

    //Methods:
    //constructor reads the file with user's request for
    //what the song to add to which playlist.

    /**
     * constructor reading users request for what song to add to which playlist
     * three objects of type Queue
     */
    Jukebox() {
        favoritePL = new Queue<SongEntry>("favorites");
        roadTripPL = new Queue<SongEntry>("road trip");
        loungePL = new Queue<SongEntry>("lounge");

    }


    // A method called fillPlaylists() reads the test file and then adds songs to one of the three queues.
    /**
     * read test file and add songs to one of the three queues
     * @param requestFile read file
     * @param allSongs look at array of songs and find song that equals the title to place in playlist
     */
    public void fillPlaylists(String requestFile, SongEntry[] allSongs) {

        File file = new File(requestFile);

        try {
            Scanner inputStream = new Scanner(file);
            //keeps reading test file while there is still values
            while (inputStream.hasNext()) {
                //gets entire line
                String data = inputStream.nextLine();
                //split string into an array of string
                String[] value = data.split(",");

                String track = value[1];
                //go through entire array to read each track name
                //use three if else statements that will check which of
                //the three playlists the song contains
                for(int k = 0; k < allSongs.length; k++) {
                    //use three if else statements that will check which of
                    //the three playlists the song contains
                    if(allSongs[k].getTitle().equals(track)) {

                        String playlist = value[0];

                        switch(playlist) {

                            case "favorites":
                                //add this item to the end of the favorites queue (favoritePL) using enqueue
                                favoritePL.enqueue(allSongs[k]);
                                break;

                            case "road trip":
                                //add this item to the end of the road trip queue (roadTripPL) using enqueue
                                roadTripPL.enqueue(allSongs[k]);
                                break;

                            case "lounge":
                                //add this item to the end of the lounge queue (loungePL) using enqueue
                                loungePL.enqueue(allSongs[k]);
                                break;
                        }

                        break;
                    }
                }
            }
            //close Scanner
            inputStream.close();
        }
        //Print if cannot find file to read
        catch (FileNotFoundException e) {
            System.out.println("file not found");
        }
    }


    //Accessor methods getFavoritePL(), getRoadTripPL() and getLoungePL() for each of the
    //three queue structures favoritePL, roadTripPL and loungePL respectively.

    /**
     * accessor methods
     * @return returns the favorite playlist
     */
    public Queue<SongEntry> getFavoritePL() {
        return favoritePL;
    }

    /**
     * accessor methods
     * @return returns the road trip playlist
     */
    public Queue<SongEntry> getRoadTripPL() {
        return roadTripPL;
    }

    /**
     * accessor methods
     * @return returns the lounge playlist
     */
    public Queue<SongEntry> getLoungePL() {
        return loungePL;
    }

}