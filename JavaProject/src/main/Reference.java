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



public class Reference implements EvaluatePP {

// ***** VDMTOOLS START Name=vdmComp KEEP=NO
  static UTIL.VDMCompare vdmComp = new UTIL.VDMCompare();
// ***** VDMTOOLS END Name=vdmComp

// ***** VDMTOOLS START Name=chapter KEEP=NO
  public volatile Integer chapter = null;
// ***** VDMTOOLS END Name=chapter

// ***** VDMTOOLS START Name=line KEEP=NO
  public volatile Integer line = null;
// ***** VDMTOOLS END Name=line

// ***** VDMTOOLS START Name=publication KEEP=NO
  public volatile Publication publication = null;
// ***** VDMTOOLS END Name=publication

// ***** VDMTOOLS START Name=sentinel KEEP=NO
  volatile Sentinel sentinel;
// ***** VDMTOOLS END Name=sentinel


// ***** VDMTOOLS START Name=ReferenceSentinel KEEP=NO
  class ReferenceSentinel extends Sentinel {

    public final int Reference = 0;

    public final int nr_functions = 1;


    public ReferenceSentinel () throws CGException {}


    public ReferenceSentinel (EvaluatePP instance) throws CGException {
      init(nr_functions, instance);
    }

  }
// ***** VDMTOOLS END Name=ReferenceSentinel
;

// ***** VDMTOOLS START Name=evaluatePP KEEP=NO
  public Boolean evaluatePP (int fnr) throws CGException {
    return new Boolean(true);
  }
// ***** VDMTOOLS END Name=evaluatePP


// ***** VDMTOOLS START Name=setSentinel KEEP=NO
  public void setSentinel () {
    try {
      sentinel = new ReferenceSentinel(this);
    }
    catch (CGException e) {
      System.out.println(e.getMessage());
    }
  }
// ***** VDMTOOLS END Name=setSentinel


// ***** VDMTOOLS START Name=Reference KEEP=NO
  public Reference () throws CGException {
    try {
      setSentinel();
    }
    catch (Exception e){

      e.printStackTrace(System.out);
      System.out.println(e.getMessage());
    }
  }
// ***** VDMTOOLS END Name=Reference


// ***** VDMTOOLS START Name=Reference KEEP=NO
  public Reference (final Integer c, final Integer l, final Publication p) throws CGException {

    try {
      setSentinel();
    }
    catch (Exception e){

      e.printStackTrace(System.out);
      System.out.println(e.getMessage());
    }
    {

      chapter = UTIL.NumberToInt(UTIL.clone(c));
      line = UTIL.NumberToInt(UTIL.clone(l));
      publication = (Publication) UTIL.clone(p);
    }
  }
// ***** VDMTOOLS END Name=Reference

}
;
