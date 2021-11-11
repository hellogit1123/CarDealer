package com.mycompany.cardealer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Car 
{
    private int id;
    private int year;
    private String make;
    private String model;
    private String owners;
    private String condition;
    private int mpg;
    
    Car()
    {
        this.id = 0;
        this.year = 0;
        this.make = "File doesn't exist";
        this.model = "File doesn't exist";
        this.owners = "File doesn't exist";
        this.condition = "File doesn't exist";
        this.mpg = 0;
    }
    
    Car(int id, int year, String make, String model, String owners, String cond, int mpg) throws IOException 
    {
        this.id = id;
        this.year = year;
        this.make = make;
        this.model = model;
        this.owners = owners;
        this.condition = cond;
        this.mpg = mpg;
        
        this.newCarwrite();
        this.appendId();
    }
    
    public int getId()
    {return this.id;}
    
    public int getYear()
    {return this.year;}
    
    public String getMake()
    {return this.make;}

    public String getModel()
    {return this.model;}

    public String getOwner()
    {return this.owners;}

    public String getCondition()
    {return this.condition;}

    public int getMpg()
    {return this.mpg;}

    public void newCarwrite() throws IOException
    {
        String foldername = "AlanCarFolder";
        String content="";
        File file = new File(foldername+"/"+String.valueOf(this.id)+".txt");
        
        while(file.exists())
        {
            System.out.println("Id number already exists.Assinging new ID");
            this.id+=13;
            file = new File(foldername+"/"+String.valueOf(this.id)+".txt");
        }
        file.getParentFile().mkdir();
        file.createNewFile();
        FileWriter fw = new FileWriter(file);
        content = String.valueOf(this.id)+"\n"+String.valueOf(this.year)+"\n"+
                  String.valueOf(this.make)+"\n"+String.valueOf(this.model)+"\n"+
                  String.valueOf(this.owners)+"\n"+String.valueOf(this.condition)+"\n"+
                  String.valueOf(this.mpg);

        fw.write(content);
        fw.close();
    }
    
    public void appendId() throws IOException
    {
        String foldername = "AlanCarFolder";
        String content="";
        File file = new File(foldername+"/"+"allMyID.txt");
        
        if(file.exists())
        {            
            file.getParentFile().mkdir();
            file.createNewFile();
            FileWriter fw = new FileWriter(file,true);
            fw.write(String.valueOf(this.id)+"\n");
            fw.close();
        }else
        {            
            file.getParentFile().mkdir();
            file.createNewFile();
            FileWriter fw = new FileWriter(file);
            fw.write(String.valueOf(this.id)+"\n");
            fw.close();
        }   
    }
    
    public String getallId() throws FileNotFoundException
    {
        String foldername = "AlanCarFolder";
        File file = new File(foldername+"/"+"allMyID.txt");
        String content = "";
        if(file.exists())
        {
            Scanner input = new Scanner(file);
            while(input.hasNext())
            {
                content+=input.nextLine()+"\n";
            }       
        }
        return content;
    }
    
    public void getFileData(String passedid) throws FileNotFoundException, IOException
    {
        String foldername = "AlanCarFolder";
        File file = new File(foldername+"/"+passedid+".txt");
        
        if(file.exists())
        {
            Scanner input = new Scanner(file);
            this.id = input.nextInt();
            this.year = input.nextInt();
            input.nextLine();
            this.make = input.nextLine();
            this.model = input.nextLine();
            this.owners = input.nextLine();
            this.condition = input.nextLine();
            this.mpg = input.nextInt();
        }
    }
}
