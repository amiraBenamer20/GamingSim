package onlinegamingproject;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.IOException;

/**
 *
 * @author Amira BENAMER
 */
public class Main_static 
{
    public static void main(String[] args) throws IOException 
    {
        
        
        String root = "C:\\Users\\amira\\";//make sure to replace D:\\ by the current directory where the code exists
        String path = root+"GamingSim\\Data_Static\\"; 
        int configurations[]={20,40,60,80,100,250,500,750,1000,1250,1500,1750,2000,3000,4000,5000};
     
        int instances=5;//Number of instances for each configuration
        int start=0;
        int rerun=1;
        
        int thresholds[]={0};//percent of players with tolerated latency violations
        
        int[]resourcesSizes={1};//specify which type of resources we look to generate
        
        for(int i=start;i<instances;i++)
        {
            for(int t=0;t<thresholds.length;t++)
            { 
                System.out.println("_*_*_*_*_*_*_*_*_*_*_*_*_*_Threshold: "+thresholds[t]+" _*_*_*_*_*_*_*_*_*_"); 
                for(int addedC=0;addedC<resourcesSizes.length;addedC++)
                {
                    for(int g=0;g<configurations.length;g++)
                    {
                       System.out.println("------------------------------CONFIG: "+configurations[g]+"----------------------------------");
                        
                        for(int j=0;j<rerun;j++)
                        {
                             Data_Generation instance=new Data_Generation(path,configurations[g],i,thresholds[t],"GA","2P",j,resourcesSizes[addedC]);
                        }
                    }
                }
            }
        }
    }
}
