/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package capstone;

import java.sql.*;
import java.util.ArrayList;
import java.math.*;

/**
 *
 * @author Nathan Cline
 */
public class DbConnector {
    // JDBC driver name and database URL and name
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost/";
   static final String DB_NAME = "Fantasy_Hockey_Projector";

   //  Database credentials - must be root to create tables!
   static final String USER = "root";
   static final String PASS = "layla";
    
    /**
     * creates a new database named FantasyHockeyProjectorDatabase, if one does
     * not already exist
     */
    public static void createDatabase() {
   Connection conn = null;
   Statement stmt = null;
   try{
      //STEP 2: Register JDBC driver
      Class.forName(JDBC_DRIVER);

      //STEP 3: Open a connection
      System.out.println("Connecting to database...");
      conn = DriverManager.getConnection(DB_URL, USER, PASS);

      //STEP 4: Execute a query
      System.out.println("Creating database...");
      stmt = conn.createStatement();
      
      String sql = "CREATE DATABASE IF NOT EXISTS "+DB_NAME;
      stmt.executeUpdate(sql);
      System.out.println("Database created successfully...");
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            stmt.close();
      }catch(SQLException se2){
      }// nothing we can do
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   }//end try
   System.out.println("Goodbye!");
}//end createDatabase
    
    /**
     * creates a new table named registration, if one
     * does not already exist
     */
    public static void createTables() {
   Connection conn = null;
   Statement stmt = null;
   try{
      //STEP 2: Register JDBC driver
      Class.forName(JDBC_DRIVER);

      //STEP 3: Open a connection
      System.out.println("Connecting to a selected database...");
      conn = DriverManager.getConnection(DB_URL+DB_NAME, USER, PASS);
      System.out.println("Connected database successfully...");
      
      //STEP 4: Execute a query
      System.out.println("Creating table in given database...");
      stmt = conn.createStatement();
     
     
     String sql = "CREATE TABLE IF NOT EXISTS Users " +
                   "(UserID INTEGER NOT NULL AUTO_INCREMENT, " +
                   " UserName VARCHAR(25) NOT NULL, " + 
                   " UserPassword VARCHAR(25) NOT NULL, " + 
                   " PRIMARY KEY ( UserID )) " ;
       stmt.executeUpdate(sql);
       sql = "INSERT INTO Users (UserName, UserPassword) " +
                   "VALUES ('shane','password')";
      stmt.executeUpdate(sql);
       
      
       sql = "CREATE TABLE IF NOT EXISTS Teams " +
                   "(TeamsID INTEGER NOT NULL AUTO_INCREMENT, " +
                   " TeamName VARCHAR(25) NOT NULL, " + 
                   " TeamRegion VARCHAR(25) NOT NULL, " + 
                   " PRIMARY KEY ( TeamsID )) " ;
                                   
       stmt.executeUpdate(sql);
       
       sql =       "INSERT INTO Teams (TeamName, TeamRegion) " +
                        "VALUES ('Hurricanes','Carolina')";
       stmt.executeUpdate(sql);
       
       sql =       "INSERT INTO Teams (TeamName, TeamRegion) " +
                        "VALUES ('Blue Jackets','Columbus')";
       stmt.executeUpdate(sql);
                   
       sql =       "CREATE TABLE IF NOT EXISTS Positions " +
                   "(PositionID INTEGER NOT NULL AUTO_INCREMENT, " +
                   " PositionName VARCHAR(15) NOT NULL, " +
                   " PRIMARY KEY ( PositionID )) " ;
                     
       
       stmt.executeUpdate(sql);
       
       sql =       "INSERT INTO Positions (PositionName) " +
                       "VALUE ('Center') " ;
       stmt.executeUpdate(sql);
       
        sql =      "INSERT INTO Positions (PositionName) " +
                       "VALUE ('Left Wing') " ;
        stmt.executeUpdate(sql);
        
         sql =     "INSERT INTO Positions (PositionName) " +
                       "VALUE ('Right Wing') " ;
         stmt.executeUpdate(sql);
         
          sql =    "INSERT INTO Positions (PositionName) " +
                       "VALUE ('Defenseman') " ;
          stmt.executeUpdate(sql);
          
          sql =         "INSERT INTO Positions (PositionName) " +
                       "VALUE ('GoalTender') " ;
          
       stmt.executeUpdate(sql);
       
       
       
        sql =      "CREATE TABLE IF NOT EXISTS Players " +
                   " (PlayerID INTEGER NOT NULL AUTO_INCREMENT, " +
                   " TeamsID INTEGER NOT NULL, " +
                   " PositionID INTEGER NOT NULL, " +
                   " FName VARCHAR(25) NOT NULL, " +
                   " LNAME VARCHAR(25) NOT NULL, " +
                   " PlayerNumber VARCHAR(5) NOT NULL, " +
                   " PRIMARY KEY (PlayerID) ) " ;
                  
        stmt.executeUpdate(sql);
        
        sql =      " INSERT INTO Players (TeamsID, PositionID, FName, LName, PlayerNumber )" +
                   " VALUES (1 , 1 , 'Eric' , 'Staal' , '12' )";
        stmt.executeUpdate(sql);
        
        sql =      " INSERT INTO Players (TeamsID, PositionID, FName, LName, PlayerNumber )" +
                   " VALUES (1, 1, 'Jordan', 'Staal', '11')";
        stmt.executeUpdate(sql);
        
         sql =      " INSERT INTO Players (TeamsID, PositionID, FName, LName, PlayerNumber )" +
                   " VALUES (1, 2, 'Jeff', 'Skinner', '53')";
        stmt.executeUpdate(sql);
        
         sql =      " INSERT INTO Players (TeamsID, PositionID, FName, LName, PlayerNumber )" +
                   " VALUES (1, 2, 'Nathan', 'Gerbe', '14')";
        stmt.executeUpdate(sql);
        
         sql =      " INSERT INTO Players (TeamsID, PositionID, FName, LName, PlayerNumber )" +
                   " VALUES (1, 3, 'Alexander', 'Semin', '28')";
        stmt.executeUpdate(sql);
        
         sql =      " INSERT INTO Players (TeamsID, PositionID, FName, LName, PlayerNumber )" +
                   " VALUES (1, 3, 'Patrick', 'Dwyer', '39')";
        stmt.executeUpdate(sql);
        
         sql =      " INSERT INTO Players (TeamsID, PositionID, FName, LName, PlayerNumber )" +
                   " VALUES (1, 4, 'Andrej', 'Sekera', '4')";
        stmt.executeUpdate(sql);
        
         sql =      " INSERT INTO Players (TeamsID, PositionID, FName, LName, PlayerNumber )" +
                   " VALUES (1, 4, 'Justin', 'Faulk', '27')";
        stmt.executeUpdate(sql);
        
         sql =      " INSERT INTO Players (TeamsID, PositionID, FName, LName, PlayerNumber )" +
                   " VALUES (1, 5, 'Justin', 'Peters', '35')";
        stmt.executeUpdate(sql);
        
         sql =      " INSERT INTO Players (TeamsID, PositionID, FName, LName, PlayerNumber )" +
                   " VALUES (1, 5, 'Cam', 'Ward', '30')";
        stmt.executeUpdate(sql);
        
         sql =      " INSERT INTO Players (TeamsID, PositionID, FName, LName, PlayerNumber )" +
                   " VALUES (2, 1, 'Ryan', 'Johansen', '19')";
        stmt.executeUpdate(sql);
        
         sql =      " INSERT INTO Players (TeamsID, PositionID, FName, LName, PlayerNumber )" +
                   " VALUES (2, 1, 'Artem', 'Anisimov', '42')";
        stmt.executeUpdate(sql);
        
         sql =      " INSERT INTO Players (TeamsID, PositionID, FName, LName, PlayerNumber )" +
                   " VALUES (2, 2, 'RJ', 'Umberger', '18')";
        stmt.executeUpdate(sql);
        
         sql =      " INSERT INTO Players (TeamsID, PositionID, FName, LName, PlayerNumber )" +
                   " VALUES (2, 2, 'Nick', 'Foligno', '71')";
        stmt.executeUpdate(sql);
        
         sql =      " INSERT INTO Players (TeamsID, PositionID, FName, LName, PlayerNumber )" +
                   " VALUES (2, 3, 'Marion', 'Gaborik', '10')";
        stmt.executeUpdate(sql);
        
         sql =      " INSERT INTO Players (TeamsID, PositionID, FName, LName, PlayerNumber )" +
                   " VALUES (2, 3, 'Cam', 'Atkinson', '13')";
        stmt.executeUpdate(sql);
        
         sql =      " INSERT INTO Players (TeamsID, PositionID, FName, LName, PlayerNumber )" +
                   " VALUES (2, 4, 'James', 'Wisniewski', '21')";
        stmt.executeUpdate(sql);
        
         sql =      " INSERT INTO Players (TeamsID, PositionID, FName, LName, PlayerNumber )" +
                   " VALUES (2, 4, 'Fedor', 'Tyutin', '51')";
        stmt.executeUpdate(sql);
        
         sql =      " INSERT INTO Players (TeamsID, PositionID, FName, LName, PlayerNumber )" +
                   " VALUES (2, 5, 'Sergei', 'Bobrobsky', '72')";
        stmt.executeUpdate(sql);
        
         sql =      " INSERT INTO Players (TeamsID, PositionID, FName, LName, PlayerNumber )" +
                   " VALUES (2, 5, 'Curtis', 'Mcelhinney', '12')";
        stmt.executeUpdate(sql);
        
              
        sql =      "CREATE TABLE IF NOT EXISTS Stats " +
                   " (StatsID INTEGER NOT NULL AUTO_INCREMENT, " +
                   " PlayerID INTEGER NOT NULL, " +
                   " Goals INTEGER NOT NULL, " +
                   " Assists INTEGER NOT NULL, " +
                   " PlusMinus INTEGER NOT NULL, " +
                   " GAA DOUBLE NOT NULL, " +
                   " Save DOUBLE NOT NULL, " +
                   " Wins INTEGER NOT NULL, " +
                   " PRIMARY KEY (StatsID)) "  ;
                  
      stmt.executeUpdate(sql);
      
         sql =      " INSERT INTO Stats (PlayerID, Goals, Assists, PlusMinus, GAA, Save, Wins )" +
                   " VALUES (1, 26, 46, 28, 0, 0, 0)";
        stmt.executeUpdate(sql);
        
         sql =      " INSERT INTO Stats (PlayerID, Goals, Assists, PlusMinus, GAA, Save, Wins )" +
                   " VALUES (2, 15, 45, 2, 0, 0, 0)";
        stmt.executeUpdate(sql);
        
         sql =      " INSERT INTO Stats (PlayerID, Goals, Assists, PlusMinus, GAA, Save, Wins )" +
                   " VALUES (3, 9, 8, 7, 0, 0, 0)";
        stmt.executeUpdate(sql);
        
         sql =      " INSERT INTO Stats (PlayerID, Goals, Assists, PlusMinus, GAA, Save, Wins )" +
                   " VALUES (4, 26, 25, 14, 0, 0, 0)";
        stmt.executeUpdate(sql);
        
         sql =      " INSERT INTO Stats (PlayerID, Goals, Assists, PlusMinus, GAA, Save, Wins )" +
                   " VALUES (5, 53, 46, 16, 0, 0, 0)";
        stmt.executeUpdate(sql);
        
         sql =      " INSERT INTO Stats (PlayerID, Goals, Assists, PlusMinus, GAA, Save, Wins )" +
                   " VALUES (6, 4, 34, 3, 0, 0, 0)";
        stmt.executeUpdate(sql);
        
         sql =      " INSERT INTO Stats (PlayerID, Goals, Assists, PlusMinus, GAA, Save, Wins )" +
                   " VALUES (7, 6, 9, -1, 0, 0, 0)";
        stmt.executeUpdate(sql);
        
         sql =      " INSERT INTO Stats (PlayerID, Goals, Assists, PlusMinus, GAA, Save, Wins )" +
                   " VALUES (8, 2, 12, -4, 0, 0, 0)";
        stmt.executeUpdate(sql);
        
         sql =      " INSERT INTO Stats (PlayerID, Goals, Assists, PlusMinus, GAA, Save, Wins )" +
                   " VALUES (9, 0, 0, 0, 1.35, 0.922, 36)";
        stmt.executeUpdate(sql);
        
         sql =      " INSERT INTO Stats (PlayerID, Goals, Assists, PlusMinus, GAA, Save, Wins )" +
                   " VALUES (10, 0, 0, 0, 2.08, 0.908, 18)";
        stmt.executeUpdate(sql);
        
         sql =      " INSERT INTO Stats (PlayerID, Goals, Assists, PlusMinus, GAA, Save, Wins )" +
                   " VALUES (11, 10, 10, -4, 0, 0, 0)";
        stmt.executeUpdate(sql);
        
         sql =      " INSERT INTO Stats (PlayerID, Goals, Assists, PlusMinus, GAA, Save, Wins )" +
                   " VALUES (12, 7, 4, -6, 0, 0, 0)";
        stmt.executeUpdate(sql);
        
         sql =      " INSERT INTO Stats (PlayerID, Goals, Assists, PlusMinus, GAA, Save, Wins )" +
                   " VALUES (13, 6, 8, -4, 0, 0, 0)";
        stmt.executeUpdate(sql);
        
         sql =      " INSERT INTO Stats (PlayerID, Goals, Assists, PlusMinus, GAA, Save, Wins )" +
                   " VALUES (14, 17, 37, 3, 0, 0, 0)";
        stmt.executeUpdate(sql);
        
         sql =      " INSERT INTO Stats (PlayerID, Goals, Assists, PlusMinus, GAA, Save, Wins )" +
                   " VALUES (15, 5, 6, 1, 0, 0, 0)";
        stmt.executeUpdate(sql);
        
         sql =      " INSERT INTO Stats (PlayerID, Goals, Assists, PlusMinus, GAA, Save, Wins )" +
                   " VALUES (16, 6, 5, -7, 0, 0, 0)";
        stmt.executeUpdate(sql);
        
         sql =      " INSERT INTO Stats (PlayerID, Goals, Assists, PlusMinus, GAA, Save, Wins )" +
                   " VALUES (17, 2, 16, -1, 0, 0, 0)";
        stmt.executeUpdate(sql);
        
         sql =      " INSERT INTO Stats (PlayerID, Goals, Assists, PlusMinus, GAA, Save, Wins )" +
                   " VALUES (18, 2, 8, -7, 0, 0, 0)";
        stmt.executeUpdate(sql);
        
         sql =      " INSERT INTO Stats (PlayerID, Goals, Assists, PlusMinus, GAA, Save, Wins )" +
                   " VALUES (19, 0, 0, 0, 0.58, 0.987, 51)";
        stmt.executeUpdate(sql);
        
          sql =      " INSERT INTO Stats (PlayerID, Goals, Assists, PlusMinus, GAA, Save, Wins )" +
                   " VALUES (20, 0, 0, 0, 2.34, 0.925, 20)";
        stmt.executeUpdate(sql);
        
      System.out.println("Created table in given database...");
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            conn.close();
      }catch(SQLException se){
      }// do nothing
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   }//end try
   System.out.println("Goodbye!");
}//end createTables
    
    
    
    
    /**
     * inserts argument into database as new player
     * @param first_name
     * @param last_name
     * @param team_name
     * @param position
     * @param number 
     */
    public static void addPlayer(String first_name, String last_name, String team_name, String position, String number) {
   Connection conn = null;
   Statement stmt = null;
   try{
      //STEP 2: Register JDBC driver
      Class.forName(JDBC_DRIVER);

      //STEP 3: Open a connection
      System.out.println("Connecting to a selected database...");
      conn = DriverManager.getConnection(DB_URL+DB_NAME, USER, PASS);
      System.out.println("Connected database successfully...");
      
      //STEP 4: Execute a query
      System.out.println("Inserting record '"+first_name+" "+last_name+"' into the table...");
      stmt = conn.createStatement();
      String sql = "SELECT TeamsID FROM Teams WHERE TeamName = '"+team_name+"'";
      ResultSet rs = stmt.executeQuery(sql) ;
       rs.next();
        int teamid  = rs.getInt("TeamsID");
       
         sql = "SELECT PositionID FROM Positions WHERE PositionName = '"+position+"'";
         rs = stmt.executeQuery(sql) ;
         rs.next();
        int positionid  = rs.getInt("PositionID");
        
       sql = "INSERT INTO Players (TeamsID, PositionID,FName,LName, PlayerNumber) " +
                   "VALUES ('"+teamid + "','" + positionid+"','"+ first_name+"','"+last_name+"','"+number+"')";
      stmt.executeUpdate(sql);
      int pid = getPlayerID(first_name,last_name);
      sql = "INSERT INTO Stats (PlayerID, Goals,Assists,PlusMinus, GAA, Save, Wins) " +
                   "VALUES ('"+pid + "'," +"0,0,0,0.0,0.0,0)";
      stmt.executeUpdate(sql);
      
      System.out.println("Inserted records into the table...");

   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            conn.close();
      }catch(SQLException se){
      }// do nothing
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   }//end try
   System.out.println("Goodbye!");
}//end addPlayer
    
      /**
     * inserts argument into database as new team
     * @param team_name
     * @param team_region
     */
    public static void addTeam(String team_name, String team_region) {
   Connection conn = null;
   Statement stmt = null;
   try{
      //STEP 2: Register JDBC driver
      Class.forName(JDBC_DRIVER);

      //STEP 3: Open a connection
      System.out.println("Connecting to a selected database...");
      conn = DriverManager.getConnection(DB_URL+DB_NAME, USER, PASS);
      System.out.println("Connected database successfully...");
      
      //STEP 4: Execute a query
      System.out.println("Inserting record '"+team_name+" "+team_region+"' into the table...");
      stmt = conn.createStatement();
      
        
       String sql = "INSERT INTO Teams (TeamName, TeamRegion) " +
                   "VALUES ('"+team_name + "','" + team_region+"')";
      stmt.executeUpdate(sql);
      
      System.out.println("Inserted records into the table...");

   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            conn.close();
      }catch(SQLException se){
      }// do nothing
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   }//end try
   System.out.println("Goodbye!");
}//end addPlayer
    
     /**
     * inserts argument into database as new position
     * @param position_name
     */
    
     public static void addPosition(String position_name) {
   Connection conn = null;
   Statement stmt = null;
   try{
      //STEP 2: Register JDBC driver
      Class.forName(JDBC_DRIVER);

      //STEP 3: Open a connection
      System.out.println("Connecting to a selected database...");
      conn = DriverManager.getConnection(DB_URL+DB_NAME, USER, PASS);
      System.out.println("Connected database successfully...");
      
      //STEP 4: Execute a query
      System.out.println("Inserting record '"+position_name+"' into the table...");
      stmt = conn.createStatement();
      
        
       String sql = "INSERT INTO Positions (PositionName) " +
                   "VALUES ('"+position_name + "')";
      stmt.executeUpdate(sql);
      
      System.out.println("Inserted records into the table...");

   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            conn.close();
      }catch(SQLException se){
      }// do nothing
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   }//end try
   System.out.println("Goodbye!");
}//end addPosition
     
     
     
    /**
     * looks up a player and returns the ID number in database of this player
     * @param first_name
     * @param last_name
     * @return player_id number (integer)
     */
    public static int getPlayerID(String first_name, String last_name) {
   Connection conn = null;
   Statement stmt = null;
   try{
      //STEP 2: Register JDBC driver
      Class.forName(JDBC_DRIVER);

      //STEP 3: Open a connection
      System.out.println("Connecting to a selected database...");
      conn = DriverManager.getConnection(DB_URL+DB_NAME, USER, PASS);
      System.out.println("Connected database successfully...");
      
      //STEP 4: Execute a query
      System.out.println("Creating update statement...");
      stmt = conn.createStatement();
      
      System.out.println("Retrieving ID for player '"+first_name+" "+last_name+"'...");
      String sql = "SELECT PlayerID FROM Players WHERE FName='"+first_name+"' AND LName='"+last_name+"'";
      ResultSet rs = stmt.executeQuery(sql);

      // NOTE: without the loop, this will return the ID of only the first match
      rs.next();
      //while(rs.next()){
         System.out.println("Player found!...");
         //Retrieve by column name
         int player_id  = rs.getInt("PlayerID");
         
         //Display values
         System.out.println("Player '"+first_name+" "+last_name+"' has ID: "+player_id+" ...");
     // }
      rs.close();
      return player_id;
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
      return -1;
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
      return -1;
   }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            conn.close();
      }catch(SQLException se){
      }// do nothing
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   }//end try
}//end getPlayerID
    
   
      /**
     * looks up a team and returns the ID number in database of this team
     * @param team_name
     * @param team_region
     * @return team_id number (integer)
     */
    public static int getTeamID(String team_name) {
   Connection conn = null;
   Statement stmt = null;
   try{
      //STEP 2: Register JDBC driver
      Class.forName(JDBC_DRIVER);

      //STEP 3: Open a connection
      System.out.println("Connecting to a selected database...");
      conn = DriverManager.getConnection(DB_URL+DB_NAME, USER, PASS);
      System.out.println("Connected database successfully...");
      
      //STEP 4: Execute a query
      System.out.println("Creating update statement...");
      stmt = conn.createStatement();
      
      System.out.println("Retrieving ID for team ' "+team_name+"'...");
      String sql = "SELECT TeamsID FROM Teams WHERE TeamName='"+team_name+"'";
      ResultSet rs = stmt.executeQuery(sql);

      // NOTE: without the loop, this will return the ID of only the first match
      rs.next();
      //while(rs.next()){
         System.out.println("Team found!...");
         //Retrieve by column name
         int team_id  = rs.getInt("TeamsID");

         //Display values
         System.out.println("Team ' "+team_name+"' has ID: "+team_id+" ...");
     // }
      rs.close();
      return team_id;
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
      return -1;
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
      return -1;
   }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            conn.close();
      }catch(SQLException se){
      }// do nothing
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   }//end try
}//end getTeamID
 
     
          /**
     * looks up a position and returns the ID number in database of this position
     * @param position_name
     * @return position_id number (integer)
     */
    public static int getPositionID(String position_name) {
   Connection conn = null;
   Statement stmt = null;
   try{
      //STEP 2: Register JDBC driver
      Class.forName(JDBC_DRIVER);

      //STEP 3: Open a connection
      System.out.println("Connecting to a selected database...");
      conn = DriverManager.getConnection(DB_URL+DB_NAME, USER, PASS);
      System.out.println("Connected database successfully...");
      
      //STEP 4: Execute a query
      System.out.println("Creating update statement...");
      stmt = conn.createStatement();
      
      System.out.println("Retrieving ID for position '"+position_name+"'...");
      String sql = "SELECT PositionID FROM Positions WHERE PositionName='"+position_name+"'";
      ResultSet rs = stmt.executeQuery(sql);

      // NOTE: without the loop, this will return the ID of only the first match
      rs.next();
      //while(rs.next()){
         System.out.println("Position found!...");
         //Retrieve by column name
         int position_id  = rs.getInt("PositionID");

         //Display values
         System.out.println("Position '"+position_name+"' has ID: "+position_id+" ...");
     // }
      rs.close();
      return position_id;
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
      return -1;
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
      return -1;
   }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            conn.close();
      }catch(SQLException se){
      }// do nothing
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   }//end try
}//end getPositionID
    
     /**
     * sets argument into database as new player goals statistic
     * @param player_id
     * @param playerGoals
     */
    
    public static void setPlayerGoals(int player_id, int playerGoals) {
   Connection conn = null;
   Statement stmt = null;
   try{
      //STEP 2: Register JDBC driver
      Class.forName(JDBC_DRIVER);

      //STEP 3: Open a connection
      System.out.println("Connecting to a selected database...");
      conn = DriverManager.getConnection(DB_URL+DB_NAME, USER, PASS);
      System.out.println("Connected database successfully...");
      
      //STEP 4: Execute a query
      System.out.println("Creating update statement...");
      stmt = conn.createStatement();
      
      System.out.println("Updating goals for player with ID '"+player_id+"'...");
      String sql = "UPDATE Stats SET Goals="+playerGoals+" WHERE PlayerID='"+player_id+"'";
      stmt.executeUpdate(sql);

      System.out.println("Player ID "+player_id+" goals statistic updated!...");
   
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            conn.close();
      }catch(SQLException se){
      }// do nothing
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   }//end try
}//end setPlayerGoals

     /**
     * looks up a playerID and returns the Player name in database of this player
     * @param player_id
     * @return player_id number (integer)
     */
    public static int getPlayerPosition_ID (int player_id) {
        
          
   Connection conn = null;
   Statement stmt = null;
   try{
      //STEP 2: Register JDBC driver
      Class.forName(JDBC_DRIVER);

      //STEP 3: Open a connection
      System.out.println("Connecting to a selected database...");
      conn = DriverManager.getConnection(DB_URL+DB_NAME, USER, PASS);
      System.out.println("Connected database successfully...");
      
      //STEP 4: Execute a query
      System.out.println("Creating update statement...");
      stmt = conn.createStatement();
      
      System.out.println("Retrieving ID for player '"+player_id+"'...");
      String sql = "SELECT PositionID FROM Players WHERE PlayerID='"+player_id+" '";
      ResultSet rs = stmt.executeQuery(sql);

      // NOTE: without the loop, this will return the ID of only the first match
      rs.next();
      //while(rs.next()){
         System.out.println("Position found!...");
         //Retrieve by column name
         int position_id  = rs.getInt("PositionName");

         //Display values
         System.out.println("PlayerID '"+player_id+"' has Position ID: "+position_id+" ...");
     // }
      rs.close();
      return position_id;
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
      return -1;
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
      return -1;
   }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            conn.close();
      }catch(SQLException se){
      }// do nothing
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   }//end try
}//end getPositionID
    
            
            
     /**
     * looks up a player and returns the Goals in database of this player uses the ID to look up statistic Goals for player
     * @param player_id
     * @return playerGoals (integer)
     */
     public static int  getPlayerStatGoals( int player_id ) {
   Connection conn = null;
   Statement stmt = null;
   

   try{
      //STEP 2: Register JDBC driver
      Class.forName(JDBC_DRIVER);

      //STEP 3: Open a connection
      System.out.println("Connecting to a selected database...");
      conn = DriverManager.getConnection(DB_URL+DB_NAME, USER, PASS);
      System.out.println("Connected database successfully...");
      
      //STEP 4: Execute a query
      System.out.println("Creating update statement...");
      stmt = conn.createStatement();
 
      System.out.println("Retrieving stats for ID  '"+player_id+"'...");
      String sql = "SELECT Goals FROM Stats WHERE PlayerID='"+player_id+"'";
      ResultSet rs = stmt.executeQuery(sql);

      // NOTE: without the loop, this will return the ID of only the first match
      rs.next();
      //while(rs.next()){
         System.out.println("Statistic goals found!...");
         //Retrieve by column name
         int playerGoals  = rs.getInt("Goals");
          

         //Display values
         System.out.println("Player with ID '"+player_id+"' has Goals: "+playerGoals+"'");
     // }
      
      rs.close();
      return playerGoals; 
      
      
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
      return -1;
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
      return -1;
   }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            conn.close();
      }catch(SQLException se){
      }// do nothing
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   }//end try
}//end  getPlayerStatGoals
     
      /**
     * sets argument into database as new player assists statistic
     * @param player_id
     * @param assists
     */
    
    public static void setPlayerAssists(int player_id, int playerAssists) {
   Connection conn = null;
   Statement stmt = null;
   try{
      //STEP 2: Register JDBC driver
      Class.forName(JDBC_DRIVER);

      //STEP 3: Open a connection
      System.out.println("Connecting to a selected database...");
      conn = DriverManager.getConnection(DB_URL+DB_NAME, USER, PASS);
      System.out.println("Connected database successfully...");
      
      //STEP 4: Execute a query
      System.out.println("Creating update statement...");
      stmt = conn.createStatement();
      
      System.out.println("Updating assists for player with ID '"+player_id+"'...");
      String sql = "UPDATE Stats SET Assists="+playerAssists+" WHERE PlayerID='"+player_id+"'";
      stmt.executeUpdate(sql);

      System.out.println("Player ID "+player_id+" assists statistic updated!...");
   
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            conn.close();
      }catch(SQLException se){
      }// do nothing
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   }//end try
}//end setPlayerAssists

     
     /**
     * looks up a player and returns the Assists in database of this player uses the ID to look up statistic Assists for player
     * @param player_id
     * @return assists (integer)
     */
     public static int  getPlayerStatAssists( int player_id ) {
   Connection conn = null;
   Statement stmt = null;
   
   try{
      //STEP 2: Register JDBC driver
      Class.forName(JDBC_DRIVER);

      //STEP 3: Open a connection
      System.out.println("Connecting to a selected database...");
      conn = DriverManager.getConnection(DB_URL+DB_NAME, USER, PASS);
      System.out.println("Connected database successfully...");
      
      //STEP 4: Execute a query
      System.out.println("Creating update statement...");
      stmt = conn.createStatement();
      
      System.out.println("Retrieving stats for ID  '"+player_id+"'...");
      String sql = "SELECT Assists FROM Stats WHERE PlayerID='"+player_id+"'";
      ResultSet rs = stmt.executeQuery(sql);

      // NOTE: without the loop, this will return the ID of only the first match
      rs.next();
      //while(rs.next()){
         System.out.println("Statistic assists found!...");
         //Retrieve by column name
        int playerAssists  = rs.getInt("Assists");
          

         //Display values
         System.out.println("Player ID "+player_id+" assists statistic updated!...");
     // }
      
      rs.close();
      return playerAssists; 
      
      
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
      return -1;
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
      return -1;
   }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            conn.close();
      }catch(SQLException se){
      }// do nothing
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   }//end try
}//end  getPlayerStatAssists
     
      /**
     * sets argument into database as new player plusMinus statistic
     * @param player_id
     * @param plusMinus
     */
    
    public static void setPlayerPlusMinus(int player_id, int plusMinus) {
   Connection conn = null;
   Statement stmt = null;
   try{
      //STEP 2: Register JDBC driver
      Class.forName(JDBC_DRIVER);

      //STEP 3: Open a connection
      System.out.println("Connecting to a selected database...");
      conn = DriverManager.getConnection(DB_URL+DB_NAME, USER, PASS);
      System.out.println("Connected database successfully...");
      
      //STEP 4: Execute a query
      System.out.println("Creating update statement...");
      stmt = conn.createStatement();
      
      System.out.println("Updating Plus/Minus for player with ID '"+player_id+"'...");
      String sql = "UPDATE Stats SET PlusMinus ="+plusMinus+" WHERE PlayerID='"+player_id+"'";
      stmt.executeUpdate(sql);

      System.out.println("Player ID "+player_id+" plus/minus statistic updated!...");
   
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            conn.close();
      }catch(SQLException se){
      }// do nothing
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   }//end try
}//end setPlayerPlusMinus

     
/**
     * looks up a player and returns the Plus/Minus in database of this player uses the ID to look up statistic PlusMinus for player
     * @param first_name
     * @param last_name
     * @param player_id
     * @return goals (integer)
     */
     public static int  getPlayerStatPlusMinus( int player_id ) {
   Connection conn = null;
   Statement stmt = null;
   
   
 
   try{
      //STEP 2: Register JDBC driver
      Class.forName(JDBC_DRIVER);

      //STEP 3: Open a connection
      System.out.println("Connecting to a selected database...");
      conn = DriverManager.getConnection(DB_URL+DB_NAME, USER, PASS);
      System.out.println("Connected database successfully...");
      
      //STEP 4: Execute a query
      System.out.println("Creating update statement...");
      stmt = conn.createStatement();
 
      System.out.println("Retrieving ID  '"+player_id+"'...");
      String sql = "SELECT PlusMinus FROM Stats WHERE PlayerID='"+player_id+"'";
      ResultSet rs = stmt.executeQuery(sql);

      // NOTE: without the loop, this will return the ID of only the first match
      rs.next();
      //while(rs.next()){
         System.out.println("Statistic Plus/Minus found!...");
         //Retrieve by column name
        int plusMinus  = rs.getInt("PlusMinus");
          

         //Display values
         System.out.println("Player ID "+player_id+" plusMinus statistic updated!...");
     // }
      
      rs.close();
      return plusMinus; 
      
      
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
      return -1;
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
      return -1;
   }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            conn.close();
      }catch(SQLException se){
      }// do nothing
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   }//end try
}//end  getPlayerStatPlusMinus
     
      /**
     * sets argument into database as new player goals against average statistic
     * @param player_id
     * @param gaa
     */
    
    public static void setPlayerGAA(int player_id, double gaa) {
   Connection conn = null;
   Statement stmt = null;
   try{
      //STEP 2: Register JDBC driver
      Class.forName(JDBC_DRIVER);

      //STEP 3: Open a connection
      System.out.println("Connecting to a selected database...");
      conn = DriverManager.getConnection(DB_URL+DB_NAME, USER, PASS);
      System.out.println("Connected database successfully...");
      
      //STEP 4: Execute a query
      System.out.println("Creating update statement...");
      stmt = conn.createStatement();
      
      System.out.println("Updating goals for player with ID '"+player_id+"'...");
      String sql = "UPDATE Stats SET GAA="+gaa+" WHERE PlayerID='"+player_id+"'";
      stmt.executeUpdate(sql);

      System.out.println("Player ID "+player_id+" goals against average statistic updated!...");
   
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            conn.close();
      }catch(SQLException se){
      }// do nothing
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   }//end try
}//end setPlayerGAA

     
   
      /**
     * looks up a player and returns the Goals Against Average in database of this player uses the ID to look up statistic GAA for player
     * @param player_id
     * @return goals (integer)
     */
     public static double  getPlayerStatGAA( int player_id ) {
   Connection conn = null;
   Statement stmt = null;
   
   try{
      //STEP 2: Register JDBC driver
      Class.forName(JDBC_DRIVER);

      //STEP 3: Open a connection
      System.out.println("Connecting to a selected database...");
      conn = DriverManager.getConnection(DB_URL+DB_NAME, USER, PASS);
      System.out.println("Connected database successfully...");
      
      //STEP 4: Execute a query
      System.out.println("Creating update statement...");
      stmt = conn.createStatement();
 
      System.out.println("Retrieving ID  '"+player_id+"'...");
      String sql = "SELECT GAA FROM Stats WHERE PlayerID='"+player_id+"'";
      ResultSet rs = stmt.executeQuery(sql);

      // NOTE: without the loop, this will return the ID of only the first match
      rs.next();
      //while(rs.next()){
         System.out.println("Statistic Goals Against Average found!...");
         //Retrieve by column name
        double gaa  = rs.getDouble("GAA");
          

         //Display values
        System.out.println("Player ID "+player_id+" goals against statistic updated!...");
     // }
      
      rs.close();
      return gaa; 
      
      
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
      return -1;
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
      return -1;
   }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            conn.close();
      }catch(SQLException se){
      }// do nothing
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   }//end try
}//end  getPlayerStatGAA
     
      /**
     * sets argument into database as new player save percentage statistic
     * @param player_id
     * @param save
     */
    
    public static void setPlayerSave(int player_id, double save) {
   Connection conn = null;
   Statement stmt = null;
   try{
      //STEP 2: Register JDBC driver
      Class.forName(JDBC_DRIVER);

      //STEP 3: Open a connection
      System.out.println("Connecting to a selected database...");
      conn = DriverManager.getConnection(DB_URL+DB_NAME, USER, PASS);
      System.out.println("Connected database successfully...");
      
      //STEP 4: Execute a query
      System.out.println("Creating update statement...");
      stmt = conn.createStatement();
      
      System.out.println("Updating save percentage for player with ID '"+player_id+"'...");
      String sql = "UPDATE Stats SET Save="+save+" WHERE PlayerID='"+player_id+"'";
      stmt.executeUpdate(sql);

      System.out.println("Player ID "+player_id+" save percentage statistic updated!...");
   
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            conn.close();
      }catch(SQLException se){
      }// do nothing
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   }//end try
}//end setPlayerSave

     
      /**
     * looks up a player and returns the Save Percentage in database of this player uses the ID to look up statistic Save for player
     * @param player_id
     * @return goals (integer)
     */
     public static double  getPlayerStatSave( int player_id ) {
   Connection conn = null;
   Statement stmt = null;
   
   
 
   try{
      //STEP 2: Register JDBC driver
      Class.forName(JDBC_DRIVER);

      //STEP 3: Open a connection
      System.out.println("Connecting to a selected database...");
      conn = DriverManager.getConnection(DB_URL+DB_NAME, USER, PASS);
      System.out.println("Connected database successfully...");
      
      //STEP 4: Execute a query
      System.out.println("Creating update statement...");
      stmt = conn.createStatement();
 
      System.out.println("Retrieving ID  '"+player_id+"'...");
      String sql = "SELECT Save FROM Stats WHERE PlayerID='"+player_id+"'";
      ResultSet rs = stmt.executeQuery(sql);

      // NOTE: without the loop, this will return the ID of only the first match
      rs.next();
      //while(rs.next()){
         System.out.println("Statistic Save Percentage found!...");
         //Retrieve by column name
        double save  = rs.getDouble("Save");
          

         //Display values
         System.out.println("Player ID'"+player_id+"' has Save Percentage: "+save+"'");
     // }
      
      rs.close();
      return save;
      
      
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
      return -1;
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
      return -1;
   }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            conn.close();
      }catch(SQLException se){
      }// do nothing
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   }//end try
}//end  getPlayerStatSave
     
        /**
     * sets argument into database as new player wins statistic
     * @param player_id
     * @param wins
     */
    
    public static void setPlayerWins(int player_id, int wins) {
   Connection conn = null;
   Statement stmt = null;
   try{
      //STEP 2: Register JDBC driver
      Class.forName(JDBC_DRIVER);

      //STEP 3: Open a connection
      System.out.println("Connecting to a selected database...");
      conn = DriverManager.getConnection(DB_URL+DB_NAME, USER, PASS);
      System.out.println("Connected database successfully...");
      
      //STEP 4: Execute a query
      System.out.println("Creating update statement...");
      stmt = conn.createStatement();
      
      System.out.println("Updating save percentage for player with ID '"+player_id+"'...");
      String sql = "UPDATE Stats SET Wins="+wins+" WHERE PlayerID='"+player_id+"'";
      stmt.executeUpdate(sql);

      System.out.println("Player ID "+player_id+" save percentage statistic updated!...");
   
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            conn.close();
      }catch(SQLException se){
      }// do nothing
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   }//end try
}//end setPlayerWins
     
      /**
     * looks up a player and returns the Wins in database of this player uses the ID to look up statistic Save for player
     * @param player_id
     * @return goals (integer)
     */
     public static int  getPlayerStatWins( int player_id ) {
   Connection conn = null;
   Statement stmt = null;
   
   
 
   try{
      //STEP 2: Register JDBC driver
      Class.forName(JDBC_DRIVER);

      //STEP 3: Open a connection
      System.out.println("Connecting to a selected database...");
      conn = DriverManager.getConnection(DB_URL+DB_NAME, USER, PASS);
      System.out.println("Connected database successfully...");
      
      //STEP 4: Execute a query
      System.out.println("Creating update statement...");
      stmt = conn.createStatement();
 
      System.out.println("Retrieving ID  '"+player_id+"'...");
      String sql = "SELECT Wins FROM Stats WHERE PlayerID='"+player_id+"'";
      ResultSet rs = stmt.executeQuery(sql);

      // NOTE: without the loop, this will return the ID of only the first match
      rs.next();
     // while(rs.next()){
         System.out.println("Wins found!...");
         //Retrieve by column name
        int wins= rs.getInt("Wins");
          

         //Display values
         System.out.println("Player ID '"+player_id+"' has Wins: "+wins+"'");
      
      
      rs.close();
      return wins;
      
      
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
      return -1;
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
      return -1;
   }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            conn.close();
      }catch(SQLException se){
      }// do nothing
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   }//end try
}//end  getPlayerStatWins
     
      /**
     * looks up a players team and returns the team name in database of this player
     * @param player_id
     * @return team (String)
     */
     
       public static String getPlayerTeam( int player_id ) {
   Connection conn = null;
   Statement stmt = null;
   
   
 
   try{
      //STEP 2: Register JDBC driver
      Class.forName(JDBC_DRIVER);

      //STEP 3: Open a connection
      System.out.println("Connecting to a selected database...");
      conn = DriverManager.getConnection(DB_URL+DB_NAME, USER, PASS);
      System.out.println("Connected database successfully...");
      
      //STEP 4: Execute a query
      System.out.println("Creating update statement...");
      stmt = conn.createStatement();
 
      System.out.println("Retrieving ID  '"+player_id+"'...");
      String sql = "SELECT Teams.TeamName, Players.TeamsID FROM Teams INNER JOIN Players ON Players.TeamsID=Teams.TeamsID  WHERE PlayerID='"+player_id+"'";
      ResultSet rs = stmt.executeQuery(sql);

      // NOTE: without the loop, this will return the ID of only the first match
      rs.next();
     // while(rs.next()){
         System.out.println("Team found!...");
         //Retrieve by column name
        String team = rs.getString ("Teams.TeamName");
          

         //Display values
         System.out.println("Player ID '"+player_id+"' has team: "+team+"'");
      
      
      rs.close();
      return team;
      
      
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
      return "";
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
      return "";
   }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            conn.close();
      }catch(SQLException se){
      }// do nothing
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   }//end try
}//end  getPlayerTeam
       
        /**
     * looks up a players position and returns the position in database of this player
     * @param player_id
     * @return position (String)
     */
       
         public static String  getPlayerPosition( int player_id ) {
   Connection conn = null;
   Statement stmt = null;
   
   
 
   try{
      //STEP 2: Register JDBC driver
      Class.forName(JDBC_DRIVER);

      //STEP 3: Open a connection
      System.out.println("Connecting to a selected database...");
      conn = DriverManager.getConnection(DB_URL+DB_NAME, USER, PASS);
      System.out.println("Connected database successfully...");
      
      //STEP 4: Execute a query
      System.out.println("Creating update statement...");
      stmt = conn.createStatement();
 
      System.out.println("Retrieving ID  '"+player_id+"'...");
      String sql = "SELECT Positions.PositionName, Players.PositionID FROM Positions INNER JOIN Players ON Players.PositionID=Positions.PositionID  WHERE PlayerID='"+player_id+"'";
      ResultSet rs = stmt.executeQuery(sql);

      // NOTE: without the loop, this will return the ID of only the first match
      rs.next();
     // while(rs.next()){
         System.out.println("Position found!...");
         //Retrieve by column name
        String position = rs.getString("Positions.PositionName");
          

         //Display values
         System.out.println("Player ID '"+player_id+"' has Wins: "+position+"'");
      
      
      rs.close();
      return position;
      
      
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
      return "";
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
      return "";
   }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            conn.close();
      }catch(SQLException se){
      }// do nothing
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   }//end try
}//end  getPlayerPosition
    
    /**
     * looks up a user and returns the ID number in database of this user
     * @param first_name
     * @param last_name
     * @return id number (integer)
     */
    public static boolean checkPassword(String username, String password) {
   Connection conn = null;
   Statement stmt = null;
   try{
      //STEP 2: Register JDBC driver
      Class.forName(JDBC_DRIVER);

      //STEP 3: Open a connection
      System.out.println("Connecting to a selected database...");
      conn = DriverManager.getConnection(DB_URL+DB_NAME, USER, PASS);
      System.out.println("Connected database successfully...");
      
      //STEP 4: Execute a query
      System.out.println("Creating select statement...");
      stmt = conn.createStatement();
      
      System.out.println("Checking password...");
      String sql = "SELECT UserPassword FROM Users WHERE UserName='"+username+"'";
      ResultSet rs = stmt.executeQuery(sql);

      // NOTE: without the loop, this will return the ID of only the first match
      rs.next();
      //while(rs.next()){
         System.out.println("Username "+username+" found!...");
         //Retrieve by column name
         String dbPassword  = rs.getString("UserPassword");
         System.out.println("Password is  '"+dbPassword+"'!...");
         
         boolean isCorrectPassword = false;
         if (dbPassword.equals(password))
         {
         isCorrectPassword = true;
                 }
         System.out.println("Logged in? "+isCorrectPassword+" ...");
     // }
      rs.close();
      return isCorrectPassword;
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
      return false;
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
      return false;
   }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            conn.close();
      }catch(SQLException se){
      }// do nothing
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   }//end try
}//end checkPassword
    
     /**
     * looks up all position name and returns the position ID from the database 
     * @param position_id
     * @return position_name
     */
    
     public static ArrayList getAllPositions() {
   Connection conn = null;
   Statement stmt = null;
   
   try{
      //STEP 2: Register JDBC driver
      Class.forName(JDBC_DRIVER);

      //STEP 3: Open a connection
      System.out.println("Connecting to a selected database...");
      conn = DriverManager.getConnection(DB_URL+DB_NAME, USER, PASS);
      System.out.println("Connected database successfully...");
      
      System.out.println("Retrieving name for all position ...");
      stmt = conn.createStatement();
      String sql = "SELECT PositionName FROM positions ORDER BY PositionName ASC";
      ResultSet rs = stmt.executeQuery(sql);

      ArrayList<String> position_name = new ArrayList<>();
      // NOTE: without the loop, this will return the ID of only the first match
      while(rs.next()){
         System.out.println("Position found!...");
         //Retrieve by column name
          position_name.add(rs.getString("PositionName"));
         
         //Display values
         System.out.println("Position "+position_name+" ..");
      }
      rs.close();
      return position_name;
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
      ArrayList<String> a = new ArrayList<String>();
      return a ;
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
     ArrayList<String> a =new ArrayList<String>();
      return a;
   }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            conn.close();
      }catch(SQLException se){
      }// do nothing
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   }//end try
}//end getAllPositions
     /**
     * looks up all teams and returns an ArrayList of all the team names in database of this player

     * @return player_id number (integer)
     */
     
       public static ArrayList getAllTeams() {
   Connection conn = null;
   Statement stmt = null;
   
   try{
      //STEP 2: Register JDBC driver
      Class.forName(JDBC_DRIVER);

      //STEP 3: Open a connection
      System.out.println("Connecting to a selected database...");
      conn = DriverManager.getConnection(DB_URL+DB_NAME, USER, PASS);
      System.out.println("Connected database successfully...");
      
      System.out.println("Retrieving name for all Teams ...");
      stmt = conn.createStatement();
      String sql = "SELECT TeamName FROM teams ORDER BY TeamName ASC ";
      ResultSet rs = stmt.executeQuery(sql);

      ArrayList<String> team_name = new ArrayList<>();
      // NOTE: without the loop, this will return the ID of only the first match
      while(rs.next()){
         System.out.println("Team found!...");
         //Retrieve by column name
          team_name.add(rs.getString("TeamName"));
         
         //Display values
         System.out.println("Team "+team_name+" ..");
      }
      rs.close();
      return team_name;
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
      ArrayList<String> a = new ArrayList<String>();
      return a ;
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
     ArrayList<String> a =new ArrayList<String>();
      return a;
   }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            conn.close();
      }catch(SQLException se){
      }// do nothing
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   }//end try
}//end getAllTeams
       
       
     /**
     * looks up a position name and returns the position ID from the database 
     * @return player_name
     */
    
     public static ArrayList getAllPlayers() {
   Connection conn = null;
   Statement stmt = null;
   
   try{
      //STEP 2: Register JDBC driver
      Class.forName(JDBC_DRIVER);

      //STEP 3: Open a connection
      System.out.println("Connecting to a selected database...");
      conn = DriverManager.getConnection(DB_URL+DB_NAME, USER, PASS);
      System.out.println("Connected database successfully...");
      
      System.out.println("Retrieving name for all position ...");
      stmt = conn.createStatement();
      String sql = "SELECT FName, LName FROM players ORDER BY LName ASC";
      ResultSet rs = stmt.executeQuery(sql);

      ArrayList<String> player_name = new ArrayList<>();
      // NOTE: without the loop, this will return the ID of only the first match
      while(rs.next()){
         System.out.println("Position found!...");
         //Retrieve by column name
          player_name.add(rs.getString("FName")+" "+rs.getString("LName"));
         
         //Display values
         System.out.println("Position "+player_name+" ..");
      }
      rs.close();
      return player_name;
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
      ArrayList<String> a = new ArrayList<String>();
      return a ;
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
     ArrayList<String> a =new ArrayList<String>();
      return a;
   }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            conn.close();
      }catch(SQLException se){
      }// do nothing
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   }//end try
}//end getAllPlayers
    
      /**
     * looks up all players on a team and returns an ArrayList of players from data in database
     * @param team_id
     * @return ArrayList playersbyteam
     */
     
         public static ArrayList getPlayersbyTeam(int team_id) {
   Connection conn = null;
   Statement stmt = null;
   
   try{
      //STEP 2: Register JDBC driver
      Class.forName(JDBC_DRIVER);

      //STEP 3: Open a connection
      System.out.println("Connecting to a selected database...");
      conn = DriverManager.getConnection(DB_URL+DB_NAME, USER, PASS);
      System.out.println("Connected database successfully...");
      
      System.out.println("Retrieving players for team ...");
      stmt = conn.createStatement();
      String sql = "SELECT FName, LName FROM players WHERE TeamsID='" +team_id+"'";
      ResultSet rs = stmt.executeQuery(sql);

      ArrayList<String> playerbyteam = new ArrayList<>();
      // NOTE: without the loop, this will return the ID of only the first match
      while(rs.next()){
         System.out.println("Players found!...");
         //Retrieve by column name
          playerbyteam.add(rs.getString("FName")+" "+rs.getString("LName"));
         
         //Display values
         System.out.println("Player "+playerbyteam+" ..");
      }
      rs.close();
      return playerbyteam;
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
      ArrayList<String> a = new ArrayList<String>();
      return a ;
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
     ArrayList<String> a =new ArrayList<String>();
      return a;
   }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            conn.close();
      }catch(SQLException se){
      }// do nothing
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   }//end try
}//end getPlayersbyTeam
         
          /**
     * looks up all players by position from the database and returns an ArrayList of all the results
     * @param position_id
     * @return playersbyposition (ArrayList)
     */
         
          public static ArrayList getPlayersbyPosition(int position_id) {
   Connection conn = null;
   Statement stmt = null;
   
   try{
      //STEP 2: Register JDBC driver
      Class.forName(JDBC_DRIVER);

      //STEP 3: Open a connection
      System.out.println("Connecting to a selected database...");
      conn = DriverManager.getConnection(DB_URL+DB_NAME, USER, PASS);
      System.out.println("Connected database successfully...");
      
      System.out.println("Retrieving players for team ...");
      stmt = conn.createStatement();
      String sql = "SELECT FName, LName FROM players WHERE PositionID='" +position_id+"'";
      ResultSet rs = stmt.executeQuery(sql);

      ArrayList<String> playerbyposition = new ArrayList<>();
      // NOTE: without the loop, this will return the ID of only the first match
      while(rs.next()){
         System.out.println("Players found!...");
         //Retrieve by column name
          playerbyposition.add(rs.getString("FName")+" "+rs.getString("LName"));
         
         //Display values
         System.out.println("Player "+playerbyposition+" ..");
      }
      rs.close();
      return playerbyposition;
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
      ArrayList<String> a = new ArrayList<String>();
      return a ;
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
     ArrayList<String> a =new ArrayList<String>();
      return a;
   }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            conn.close();
      }catch(SQLException se){
      }// do nothing
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   }//end try
}//end getPlayersbyPosition
          
           /**
     * looks up a player and returns the star rating based on our algorithm
     * @param player_id
     * @return player_id number (integer)
     */
          
          public static int getStarRating(int player_id) {
              int goals = getPlayerStatGoals(player_id);
              int assists = getPlayerStatAssists(player_id);
              int plusMinus = getPlayerStatPlusMinus(player_id);
              double gaa = getPlayerStatGAA(player_id);
              double save = getPlayerStatSave(player_id);
              int wins = getPlayerStatWins(player_id);
              int position_id = getPlayerPosition_ID(player_id);
              int star = 0;
              int x;
              double y;
              if (position_id != 5) {
                  goals = goals * 2;
                  x = (goals + assists + plusMinus) / 3;
                    if (x >= 41) {
                        star = 5;
                    }
                       else if (x >= 31) {
                            star = 4;
                            
                       }
                               else if (x >= 21)
                               {
                                    star = 3;
                               }
                                  else if (x >= 11)
                                  {
                                        star = 2;
                                  }
                                        else  
                                  {
                                            star =  1;
                                  }
                                 
                             }
                
              else {
                gaa = gaa * 100;
                save = save * 1000;
                wins = wins * 20;
                y = ( (save - gaa) + wins) / 3;
                    if (y >= 401){
                        star = 5;}
                       else if (y >= 301){
                            star = 4;}
                               else if (y >= 201){
                                    star = 3;}
                                  else if (y >= 101){
                                        star = 2;}
                                       else {
                                            star =  1;}
              }
              return star;
     
         }

}//end class

