//
// THIS FILE IS AUTOMATICALLY GENERATED!!
//
// Generated at Tue 22-Nov-2011 by the VDM++ to JAVA Code Generator
// (v8.0 - Mon 09-Jul-2007 09:32:40)
//
// Supported compilers:
// jdk1.4
//

// ***** VDMTOOLS START Name=HeaderComment KEEP=NO
// ***** VDMTOOLS END Name=HeaderComment

// ***** VDMTOOLS START Name=package KEEP=NO
package main;

// ***** VDMTOOLS END Name=package

// ***** VDMTOOLS START Name=imports KEEP=NO

import jp.co.csk.vdm.toolbox.VDM.*;
import java.util.*;
import jp.co.csk.vdm.toolbox.VDM.jdk.*;
// ***** VDMTOOLS END Name=imports



public class Author implements EvaluatePP {

// ***** VDMTOOLS START Name=vdmComp KEEP=NO
  static UTIL.VDMCompare vdmComp = new UTIL.VDMCompare();
// ***** VDMTOOLS END Name=vdmComp

// ***** VDMTOOLS START Name=name KEEP=NO
  public volatile String name = null;
// ***** VDMTOOLS END Name=name

// ***** VDMTOOLS START Name=interests KEEP=NO
  public volatile HashSet interests = new HashSet();
// ***** VDMTOOLS END Name=interests

// ***** VDMTOOLS START Name=affiliations KEEP=NO
  public volatile HashSet affiliations = new HashSet();
// ***** VDMTOOLS END Name=affiliations

// ***** VDMTOOLS START Name=sentinel KEEP=NO
  volatile Sentinel sentinel;
// ***** VDMTOOLS END Name=sentinel


// ***** VDMTOOLS START Name=AuthorSentinel KEEP=NO
  class AuthorSentinel extends Sentinel {

    public final int Author = 0;

    public final int setName = 1;

    public final int addInterest = 2;

    public final int nr_functions = 3;


    public AuthorSentinel () throws CGException {}


    public AuthorSentinel (EvaluatePP instance) throws CGException {
      init(nr_functions, instance);
    }

  }
// ***** VDMTOOLS END Name=AuthorSentinel
;

// ***** VDMTOOLS START Name=evaluatePP KEEP=NO
  public Boolean evaluatePP (int fnr) throws CGException {
    return new Boolean(true);
  }
// ***** VDMTOOLS END Name=evaluatePP


// ***** VDMTOOLS START Name=setSentinel KEEP=NO
  public void setSentinel () {
    try {
      sentinel = new AuthorSentinel(this);
    }
    catch (CGException e) {
      System.out.println(e.getMessage());
    }
  }
// ***** VDMTOOLS END Name=setSentinel


// ***** VDMTOOLS START Name=Author KEEP=NO
  public Author () throws CGException {
    try {

      setSentinel();
      interests = new HashSet();
      affiliations = new HashSet();
    }
    catch (Exception e){

      e.printStackTrace(System.out);
      System.out.println(e.getMessage());
    }
  }
// ***** VDMTOOLS END Name=Author


// ***** VDMTOOLS START Name=Author KEEP=NO
  public Author (final String n) throws CGException {

    try {

      setSentinel();
      interests = new HashSet();
      affiliations = new HashSet();
    }
    catch (Exception e){

      e.printStackTrace(System.out);
      System.out.println(e.getMessage());
    }
    name = UTIL.ConvertToString(UTIL.clone(n));
  }
// ***** VDMTOOLS END Name=Author


// ***** VDMTOOLS START Name=addInterest KEEP=NO
  public void addInterest (final Interest i) throws CGException {

    if (!this.pre_addInterest(i).booleanValue()) 
      UTIL.RunTime("Run-Time Error:Precondition failure in addInterest");
    sentinel.entering(((AuthorSentinel) sentinel).addInterest);
    try {
      interests.add(i);
    }
    finally {
      sentinel.leaving(((AuthorSentinel) sentinel).addInterest);
    }
  }
// ***** VDMTOOLS END Name=addInterest


// ***** VDMTOOLS START Name=pre_addInterest KEEP=NO
  public Boolean pre_addInterest (final Interest i) throws CGException {

    Boolean varRes_2 = null;
    varRes_2 = new Boolean(!interests.contains(i));
    return varRes_2;
  }
// ***** VDMTOOLS END Name=pre_addInterest


// ***** VDMTOOLS START Name=setName KEEP=NO
  public void setName (final String n) throws CGException {

    sentinel.entering(((AuthorSentinel) sentinel).setName);
    try {
      name = UTIL.ConvertToString(UTIL.clone(n));
    }
    finally {
      sentinel.leaving(((AuthorSentinel) sentinel).setName);
    }
  }
// ***** VDMTOOLS END Name=setName

}
;