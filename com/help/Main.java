package com.help;

import java.util.Scanner;
class Main
{
public static void main(String args[])
{
 int i,dur;
 String name,artists,lang;
 double rating;
 Scanner sc=new Scanner(System.in);
 Songs[] arr=new Songs[5];
 for(i=0;i<5;i++)
 {
  name=sc.nextLine();
  dur=sc.nextInt();sc.nextLine();
  artists=sc.nextLine().toLowerCase();
  lang=sc.nextLine().toLowerCase();
  rating=sc.nextDouble();sc.nextLine();
  arr[i]=new Songs(name,dur,artists,lang,rating);
 }
 String lang2=sc.nextLine().toLowerCase();
 String art=sc.nextLine().toLowerCase();
 
 String[] res1=findSongBasedOnLanguage(arr,lang2);
 if(res1==null)
  System.out.println("There are no songs with the given language");
 else
 {
  for(i=0;i<res1.length;i++)
   System.out.println(res1[i]);
 }
 
 Songs[] res2=findSongBasedOnArtists(arr,art);
 if(res2==null)
  System.out.println("There are no Songs with the given artists");
 else
 {
  for(i=0;i<res2.length;i++)
  {
  System.out.println(res2[i].getSongName());
  System.out.println(res2[i].getRating());
  }
 }
  
}


public static String[] findSongBasedOnLanguage(Songs[] arr,String lang2)
{
 int i,j=0;
 String[] temp;
 for(i=0;i<arr.length;i++)
 {
  if(arr[i].getLanguage().equalsIgnoreCase(lang2))
   j++;
 }
 if(j==0)
  return null;
 else
 {
  temp=new String[j];
  j=0;
  for(i=0;i<arr.length;i++)
 {
  if(arr[i].getLanguage().equalsIgnoreCase(lang2))
   temp[j++]=arr[i].getSongName();
 }
 return temp;
 }
}


public static Songs[] findSongBasedOnArtists(Songs[] arr,String art)
{
 int i,j=0,k;
 Songs[] temp;
 for(i=0;i<arr.length;i++)
 {
  if(arr[i].getArtists().equalsIgnoreCase(art))
   j++;
 }
 if(j==0)
  return null;
 else
 {
  temp=new Songs[j];
  j=0;
  for(i=0;i<arr.length;i++)
 {
  if(arr[i].getArtists().equalsIgnoreCase(art))
   temp[j++]=arr[i];
 }
 
 for(i=0;i<j-1;i++)
 {
  for(k=0;k<j-1;k++)
  {
   if(temp[k].getRating()>temp[k+1].getRating())
   {
    Songs t=temp[k];
    temp[k]=temp[k+1];
    temp[k+1]=t;
   }
  }
 }
 return temp;
 }
}

}


class Songs
{
 private String songName;
 private int duration;
 private String artists;
 private String language;
 private double rating;
 
 public Songs(String songName,int duartion,String artists,String language,double rating)
 {
  this.songName=songName;
  this.duration=duration;
  this.artists=artists;
  this.language=language;
  this.rating=rating;
 }
 public String getSongName()
 {
  return songName;
 }
 public int getDuration()
 {
  return duration;
 }
 public String getArtists()
 {
  return artists;
 }
 public String getLanguage()
 {
  return language;
 }
 public double getRating()
 {
  return rating;
 }
}