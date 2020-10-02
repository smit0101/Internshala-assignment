//SMIT KALKANI
//smitkalkani9099@gmail.com
//INTERNSHALA GIVEN TASK


package com.smit.task;



public class Main{

    private static int getNumberOfClusters(int[][] array){
        int numberOfClusters = 0;
        int numberOfRaws = array.length;
        int numberOfColumn = array[0].length;

        //visiting each vertex if it's value is 1
        for(int row = 0; row < array.length; ++row ){
            for(int column = 0; column < array.length; ++column ){
                if( array[row][column] == 1 ){
                    //because we value of vertex is 1 we will check for it's four direction vertex as well
                    traversal(array, row, column, numberOfRaws, numberOfColumn);
                    numberOfClusters++;

                }
            }
        }

        // setting visited vertex with 1 as we have set it to -1
        for(int raw = 0; raw < array.length; ++raw){
            for(int column = 0; column < array.length; ++column ){

                if(array[raw][column] == -1) array[raw][column] = 1;
            }
        }
       //simply returning numberOfClusters we found
        return numberOfClusters;
    }

    private static void traversal(int[][] arr,int raw,int column,int numberOfRaws,int numberOfColumn){
        // This are conditions if one of them evaluates to true we will return from function
        if( raw < 0 || raw == numberOfRaws || column < 0 || column == numberOfColumn || arr[raw][column] != 1 ) return;
        //marking visited vertex with -1 we will later set this to 1 to restore it
        arr[raw][column] = -1;
        //traversal for four direction up down right left for vertex with value 1
        traversal(arr,raw-1,column,numberOfRaws,numberOfColumn);
        traversal(arr,raw+1,column,numberOfRaws,numberOfColumn);
        traversal(arr,raw,column-1,numberOfRaws,numberOfColumn);
        traversal(arr,raw,column+1,numberOfRaws,numberOfColumn);

    }





    public static void main(String[] args) {

     int[][] givenArray = {
             {1,1,1,1,0},
             {1,1,0,1,0},
             {1,1,0,0,0},
             {0,0,0,0,0}
     };

     int[][] givenArrayTwo = {
            {1,1,0,0,0},
            {1,1,0,0,0},
            {0,0,1,0,0},
            {0,0,0,1,1}

        };

        System.out.println("Result of task one::: "+getNumberOfClusters(givenArray));
        System.out.println("Result of task two::: "+getNumberOfClusters(givenArrayTwo));

    }

}
