//
// THIS FILE IS AUTOMATICALLY GENERATED!!
//
// Generated at Wed 23-Nov-2011 by the VDM++ to JAVA Code Generator
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



public class Indexer implements EvaluatePP {

// ***** VDMTOOLS START Name=vdmComp KEEP=NO
  static UTIL.VDMCompare vdmComp = new UTIL.VDMCompare();
// ***** VDMTOOLS END Name=vdmComp

// ***** VDMTOOLS START Name=publications KEEP=NO
  public volatile HashSet publications = new HashSet();
// ***** VDMTOOLS END Name=publications

// ***** VDMTOOLS START Name=authors KEEP=NO
  public volatile HashMap authors = new HashMap();
// ***** VDMTOOLS END Name=authors

// ***** VDMTOOLS START Name=affiliations KEEP=NO
  public volatile HashSet affiliations = new HashSet();
// ***** VDMTOOLS END Name=affiliations

// ***** VDMTOOLS START Name=sentinel KEEP=NO
  volatile Sentinel sentinel;
// ***** VDMTOOLS END Name=sentinel


// ***** VDMTOOLS START Name=IndexerSentinel KEEP=NO
  class IndexerSentinel extends Sentinel {

    public final int Indexer = 0;

    public final int addAuthor = 1;

    public final int pathBetween = 2;

    public final int coAuthorPath = 3;

    public final int addAffiliation = 4;

    public final int addPublication = 5;

    public final int pathBetweenAux = 6;

    public final int distanceBetween = 7;

    public final int getAuthorsByAff = 8;

    public final int distanceBetweenAux = 9;

    public final int countCitationsByMyself = 10;

    public final int countCitationsByOthers = 11;

    public final int getPublicationsByAuthor = 12;

    public final int countPublicationsByAuthor = 13;

    public final int nr_functions = 14;


    public IndexerSentinel () throws CGException {}


    public IndexerSentinel (EvaluatePP instance) throws CGException {
      init(nr_functions, instance);
    }

  }
// ***** VDMTOOLS END Name=IndexerSentinel
;

// ***** VDMTOOLS START Name=evaluatePP KEEP=NO
  public Boolean evaluatePP (int fnr) throws CGException {
    return new Boolean(true);
  }
// ***** VDMTOOLS END Name=evaluatePP


// ***** VDMTOOLS START Name=setSentinel KEEP=NO
  public void setSentinel () {
    try {
      sentinel = new IndexerSentinel(this);
    }
    catch (CGException e) {
      System.out.println(e.getMessage());
    }
  }
// ***** VDMTOOLS END Name=setSentinel


// ***** VDMTOOLS START Name=Indexer KEEP=NO
  public Indexer () throws CGException {

    try {
      setSentinel();
    }
    catch (Exception e){

      e.printStackTrace(System.out);
      System.out.println(e.getMessage());
    }
    try {

      {

        publications = (HashSet) UTIL.clone(new HashSet());
        authors = (HashMap) UTIL.clone(new HashMap());
      }
      setSentinel();
    }
    catch (Throwable e) {
      System.out.println(e.getMessage());
    }
  }
// ***** VDMTOOLS END Name=Indexer


// ***** VDMTOOLS START Name=addPublication KEEP=NO
  public void addPublication (final Publication p) throws CGException {

    if (!this.pre_addPublication(p).booleanValue()) 
      UTIL.RunTime("Run-Time Error:Precondition failure in addPublication");
    sentinel.entering(((IndexerSentinel) sentinel).addPublication);
    try {
      publications.add(p);
    }
    finally {
      sentinel.leaving(((IndexerSentinel) sentinel).addPublication);
    }
  }
// ***** VDMTOOLS END Name=addPublication


// ***** VDMTOOLS START Name=pre_addPublication KEEP=NO
  public Boolean pre_addPublication (final Publication p) throws CGException {

    Boolean varRes_2 = null;
    Boolean var1_3 = null;
    Boolean var1_4 = null;
    var1_4 = new Boolean(!publications.contains(p));
    {
      if ((var1_3 = var1_4).booleanValue()) {

        Boolean var2_7 = null;
        HashSet var1_8 = new HashSet();
        var1_8 = p.authors;
        HashSet var2_10 = new HashSet();
        var2_10.clear();
        var2_10.addAll(authors.keySet());
        var2_7 = new Boolean(var2_10.containsAll(var1_8));
        var1_3 = var2_7;
      }
    }
    {
      if ((varRes_2 = var1_3).booleanValue()) {

        Boolean var2_12 = null;
        boolean tmpQuant_13 = true;
        {

          HashSet e_set_19 = new HashSet();
          e_set_19 = p.references;
          Reference ref = null;
          {
            for (Iterator enm_22 = e_set_19.iterator(); enm_22.hasNext() && tmpQuant_13; ) {

              Reference elem_21 = (Reference) enm_22.next();
              ref = (Reference) elem_21;
              Boolean pred_14 = null;
              Publication var1_15 = null;
              var1_15 = ref.publication;
              pred_14 = new Boolean(publications.contains(var1_15));
              if (pred_14.booleanValue()) {}
              else 
                tmpQuant_13 = false;
            }
          }
        }
        var2_12 = new Boolean(tmpQuant_13);
        varRes_2 = var2_12;
      }
    }
    return varRes_2;
  }
// ***** VDMTOOLS END Name=pre_addPublication


// ***** VDMTOOLS START Name=countPublicationsByAuthor KEEP=NO
  public Double countPublicationsByAuthor (final Author a) throws CGException {

    if (!this.pre_countPublicationsByAuthor(a).booleanValue()) 
      UTIL.RunTime("Run-Time Error:Precondition failure in countPublicationsByAuthor");
    sentinel.entering(((IndexerSentinel) sentinel).countPublicationsByAuthor);
    try {

      Double count = UTIL.NumberToReal(new Double(0));
      {

        Publication pub = null;
        for (Iterator enm_13 = publications.iterator(); enm_13.hasNext(); ) {

          Publication elem_3 = (Publication) enm_13.next();
          pub = (Publication) elem_3;
          {

            Boolean cond_6 = null;
            HashSet var2_8 = new HashSet();
            var2_8 = pub.authors;
            cond_6 = new Boolean(var2_8.contains(a));
            if (cond_6.booleanValue()) 
              count = UTIL.NumberToReal(UTIL.clone(new Double(count.doubleValue() + new Integer(1).intValue())));
          }
        }
      }
      return count;
    }
    finally {
      sentinel.leaving(((IndexerSentinel) sentinel).countPublicationsByAuthor);
    }
  }
// ***** VDMTOOLS END Name=countPublicationsByAuthor


// ***** VDMTOOLS START Name=pre_countPublicationsByAuthor KEEP=NO
  public Boolean pre_countPublicationsByAuthor (final Author a) throws CGException {

    Boolean varRes_2 = null;
    varRes_2 = new Boolean(authors.containsKey(a));
    return varRes_2;
  }
// ***** VDMTOOLS END Name=pre_countPublicationsByAuthor


// ***** VDMTOOLS START Name=countCitationsByOthers KEEP=NO
  public Double countCitationsByOthers (final Author a) throws CGException {

    if (!this.pre_countCitationsByOthers(a).booleanValue()) 
      UTIL.RunTime("Run-Time Error:Precondition failure in countCitationsByOthers");
    sentinel.entering(((IndexerSentinel) sentinel).countCitationsByOthers);
    try {

      Double count = UTIL.NumberToReal(new Double(0));
      {

        Publication pub = null;
        for (Iterator enm_25 = publications.iterator(); enm_25.hasNext(); ) {

          Publication elem_3 = (Publication) enm_25.next();
          pub = (Publication) elem_3;
          {

            Boolean cond_6 = null;
            HashSet var2_8 = new HashSet();
            var2_8 = pub.authors;
            cond_6 = new Boolean(!var2_8.contains(a));
            if (cond_6.booleanValue()) {

              HashSet iset_10 = new HashSet();
              iset_10 = pub.references;
              Reference ref = null;
              for (Iterator enm_24 = iset_10.iterator(); enm_24.hasNext(); ) {

                Reference elem_11 = (Reference) enm_24.next();
                ref = (Reference) elem_11;
                {

                  Boolean cond_16 = null;
                  HashSet var2_18 = new HashSet();
                  Publication tmpRec_19 = null;
                  tmpRec_19 = ref.publication;
                  var2_18 = tmpRec_19.authors;
                  cond_16 = new Boolean(var2_18.contains(a));
                  if (cond_16.booleanValue()) 
                    count = UTIL.NumberToReal(UTIL.clone(new Double(count.doubleValue() + new Integer(1).intValue())));
                }
              }
            }
          }
        }
      }
      return count;
    }
    finally {
      sentinel.leaving(((IndexerSentinel) sentinel).countCitationsByOthers);
    }
  }
// ***** VDMTOOLS END Name=countCitationsByOthers


// ***** VDMTOOLS START Name=pre_countCitationsByOthers KEEP=NO
  public Boolean pre_countCitationsByOthers (final Author a) throws CGException {

    Boolean varRes_2 = null;
    varRes_2 = new Boolean(authors.containsKey(a));
    return varRes_2;
  }
// ***** VDMTOOLS END Name=pre_countCitationsByOthers


// ***** VDMTOOLS START Name=countCitationsByMyself KEEP=NO
  public Double countCitationsByMyself (final Author a) throws CGException {

    if (!this.pre_countCitationsByMyself(a).booleanValue()) 
      UTIL.RunTime("Run-Time Error:Precondition failure in countCitationsByMyself");
    sentinel.entering(((IndexerSentinel) sentinel).countCitationsByMyself);
    try {

      Double count = UTIL.NumberToReal(new Double(0));
      {

        Publication pub = null;
        for (Iterator enm_25 = publications.iterator(); enm_25.hasNext(); ) {

          Publication elem_3 = (Publication) enm_25.next();
          pub = (Publication) elem_3;
          {

            Boolean cond_6 = null;
            HashSet var2_8 = new HashSet();
            var2_8 = pub.authors;
            cond_6 = new Boolean(var2_8.contains(a));
            if (cond_6.booleanValue()) {

              HashSet iset_10 = new HashSet();
              iset_10 = pub.references;
              Reference ref = null;
              for (Iterator enm_24 = iset_10.iterator(); enm_24.hasNext(); ) {

                Reference elem_11 = (Reference) enm_24.next();
                ref = (Reference) elem_11;
                {

                  Boolean cond_16 = null;
                  HashSet var2_18 = new HashSet();
                  Publication tmpRec_19 = null;
                  tmpRec_19 = ref.publication;
                  var2_18 = tmpRec_19.authors;
                  cond_16 = new Boolean(var2_18.contains(a));
                  if (cond_16.booleanValue()) 
                    count = UTIL.NumberToReal(UTIL.clone(new Double(count.doubleValue() + new Integer(1).intValue())));
                }
              }
            }
          }
        }
      }
      return count;
    }
    finally {
      sentinel.leaving(((IndexerSentinel) sentinel).countCitationsByMyself);
    }
  }
// ***** VDMTOOLS END Name=countCitationsByMyself


// ***** VDMTOOLS START Name=pre_countCitationsByMyself KEEP=NO
  public Boolean pre_countCitationsByMyself (final Author a) throws CGException {

    Boolean varRes_2 = null;
    varRes_2 = new Boolean(authors.containsKey(a));
    return varRes_2;
  }
// ***** VDMTOOLS END Name=pre_countCitationsByMyself


// ***** VDMTOOLS START Name=coAuthorPath KEEP=NO
  public HashSet coAuthorPath (final Author a) throws CGException {

    if (!this.pre_coAuthorPath(a).booleanValue()) 
      UTIL.RunTime("Run-Time Error:Precondition failure in coAuthorPath");
    sentinel.entering(((IndexerSentinel) sentinel).coAuthorPath);
    try {

      HashSet auths = new HashSet();
      {

        Publication pub = null;
        for (Iterator enm_14 = publications.iterator(); enm_14.hasNext(); ) {

          Publication elem_3 = (Publication) enm_14.next();
          pub = (Publication) elem_3;
          {

            Boolean cond_6 = null;
            HashSet var2_8 = new HashSet();
            var2_8 = pub.authors;
            cond_6 = new Boolean(var2_8.contains(a));
            if (cond_6.booleanValue()) {

              HashSet rhs_10 = new HashSet();
              HashSet var2_12 = new HashSet();
              var2_12 = pub.authors;
              rhs_10 = (HashSet) auths.clone();
              rhs_10.addAll(var2_12);
              auths = (HashSet) UTIL.clone(rhs_10);
            }
          }
        }
      }
      HashSet rhs_15 = new HashSet();
      HashSet var2_17 = new HashSet();
      var2_17 = new HashSet();
      var2_17.add(a);
      rhs_15 = (HashSet) auths.clone();
      rhs_15.removeAll(var2_17);
      auths = (HashSet) UTIL.clone(rhs_15);
      return auths;
    }
    finally {
      sentinel.leaving(((IndexerSentinel) sentinel).coAuthorPath);
    }
  }
// ***** VDMTOOLS END Name=coAuthorPath


// ***** VDMTOOLS START Name=pre_coAuthorPath KEEP=NO
  public Boolean pre_coAuthorPath (final Author a) throws CGException {

    Boolean varRes_2 = null;
    varRes_2 = new Boolean(authors.containsKey(a));
    return varRes_2;
  }
// ***** VDMTOOLS END Name=pre_coAuthorPath


// ***** VDMTOOLS START Name=distanceBetween KEEP=NO
  public Double distanceBetween (final Author a1, final Author a2) throws CGException {

    sentinel.entering(((IndexerSentinel) sentinel).distanceBetween);
    try {

      Double rexpr_3 = null;
      HashSet par_7 = new HashSet();
      par_7 = new HashSet();
      par_7.add(a1);
      rexpr_3 = distanceBetweenAux((Author) a1, (Author) a2, UTIL.NumberToReal(new Integer(0)), par_7);
      return rexpr_3;
    }
    finally {
      sentinel.leaving(((IndexerSentinel) sentinel).distanceBetween);
    }
  }
// ***** VDMTOOLS END Name=distanceBetween


// ***** VDMTOOLS START Name=distanceBetweenAux KEEP=NO
  public Double distanceBetweenAux (final Author a1, final Author a2, final Double sum, final HashSet visited) throws CGException {

    if (!this.pre_distanceBetweenAux(a1, a2, sum, visited).booleanValue()) 
      UTIL.RunTime("Run-Time Error:Precondition failure in distanceBetweenAux");
    sentinel.entering(((IndexerSentinel) sentinel).distanceBetweenAux);
    try {

      {

        Publication pub = null;
        for (Iterator enm_21 = publications.iterator(); enm_21.hasNext(); ) {

          Publication elem_6 = (Publication) enm_21.next();
          pub = (Publication) elem_6;
          {

            Boolean cond_9 = null;
            Boolean var1_10 = null;
            HashSet var2_12 = new HashSet();
            var2_12 = pub.authors;
            var1_10 = new Boolean(var2_12.contains(a1));
            {
              if ((cond_9 = var1_10).booleanValue()) {

                Boolean var2_14 = null;
                HashSet var2_16 = new HashSet();
                var2_16 = pub.authors;
                var2_14 = new Boolean(var2_16.contains(a2));
                cond_9 = var2_14;
              }
            }
            if (cond_9.booleanValue()) 
              return new Double(sum.doubleValue() + new Integer(1).intValue());
          }
        }
      }
      {

        Publication pub = null;
        for (Iterator enm_58 = publications.iterator(); enm_58.hasNext(); ) {

          Publication elem_23 = (Publication) enm_58.next();
          pub = (Publication) elem_23;
          {

            Boolean cond_26 = null;
            HashSet var2_28 = new HashSet();
            var2_28 = pub.authors;
            cond_26 = new Boolean(var2_28.contains(a1));
            if (cond_26.booleanValue()) {

              HashSet iset_30 = new HashSet();
              iset_30 = pub.authors;
              Author a3 = null;
              for (Iterator enm_57 = iset_30.iterator(); enm_57.hasNext(); ) {

                Author elem_31 = (Author) enm_57.next();
                a3 = (Author) elem_31;
                {

                  Boolean cond_36 = null;
                  Boolean var1_37 = null;
                  {
                    if ((var1_37 = new Boolean(!UTIL.equals(a3, a2))).booleanValue()) 
                      var1_37 = new Boolean(!UTIL.equals(a3, a1));
                  }
                  {
                    if ((cond_36 = var1_37).booleanValue()) {

                      Boolean var2_44 = null;
                      var2_44 = new Boolean(!visited.contains(a3));
                      cond_36 = var2_44;
                    }
                  }
                  if (cond_36.booleanValue()) {

                    HashSet tmpArg_v_53 = new HashSet();
                    HashSet var2_55 = new HashSet();
                    var2_55 = new HashSet();
                    var2_55.add(a3);
                    tmpArg_v_53 = (HashSet) visited.clone();
                    tmpArg_v_53.addAll(var2_55);
                    return distanceBetweenAux((Author) a3, (Author) a2, new Double(sum.doubleValue() + new Integer(1).intValue()), tmpArg_v_53);
                  }
                }
              }
            }
          }
        }
      }
      return UTIL.NumberToReal(new Integer(0));
    }
    finally {
      sentinel.leaving(((IndexerSentinel) sentinel).distanceBetweenAux);
    }
  }
// ***** VDMTOOLS END Name=distanceBetweenAux


// ***** VDMTOOLS START Name=pre_distanceBetweenAux KEEP=NO
  public Boolean pre_distanceBetweenAux (final Author a1, final Author a2, final Double sum, final HashSet visited) throws CGException {

    Boolean varRes_5 = null;
    Boolean var1_6 = null;
    {
      if ((var1_6 = new Boolean(!UTIL.equals(a1, a2))).booleanValue()) {

        Boolean var2_10 = null;
        var2_10 = new Boolean(authors.containsKey(a1));
        var1_6 = var2_10;
      }
    }
    {
      if ((varRes_5 = var1_6).booleanValue()) {

        Boolean var2_13 = null;
        var2_13 = new Boolean(authors.containsKey(a2));
        varRes_5 = var2_13;
      }
    }
    return varRes_5;
  }
// ***** VDMTOOLS END Name=pre_distanceBetweenAux


// ***** VDMTOOLS START Name=pathBetween KEEP=NO
  public Vector pathBetween (final Author a1, final Author a2) throws CGException {

    sentinel.entering(((IndexerSentinel) sentinel).pathBetween);
    try {

      Vector rexpr_3 = null;
      Vector par_6 = null;
      par_6 = new Vector();
      par_6.add(a1);
      rexpr_3 = pathBetweenAux((Author) a1, (Author) a2, par_6);
      return rexpr_3;
    }
    finally {
      sentinel.leaving(((IndexerSentinel) sentinel).pathBetween);
    }
  }
// ***** VDMTOOLS END Name=pathBetween


// ***** VDMTOOLS START Name=pathBetweenAux KEEP=NO
  public Vector pathBetweenAux (final Author a1, final Author a2, final Vector visited) throws CGException {

    if (!this.pre_pathBetweenAux(a1, a2, visited).booleanValue()) 
      UTIL.RunTime("Run-Time Error:Precondition failure in pathBetweenAux");
    sentinel.entering(((IndexerSentinel) sentinel).pathBetweenAux);
    try {

      {

        Publication pub = null;
        for (Iterator enm_21 = publications.iterator(); enm_21.hasNext(); ) {

          Publication elem_5 = (Publication) enm_21.next();
          pub = (Publication) elem_5;
          {

            Boolean cond_8 = null;
            Boolean var1_9 = null;
            HashSet var2_11 = new HashSet();
            var2_11 = pub.authors;
            var1_9 = new Boolean(var2_11.contains(a1));
            {
              if ((cond_8 = var1_9).booleanValue()) {

                Boolean var2_13 = null;
                HashSet var2_15 = new HashSet();
                var2_15 = pub.authors;
                var2_13 = new Boolean(var2_15.contains(a2));
                cond_8 = var2_13;
              }
            }
            if (cond_8.booleanValue()) {

              Vector rexpr_17 = null;
              Vector var2_19 = null;
              var2_19 = new Vector();
              var2_19.add(a2);
              rexpr_17 = (Vector) visited.clone();
              rexpr_17.addAll(var2_19);
              return rexpr_17;
            }
          }
        }
      }
      {

        Publication pub = null;
        for (Iterator enm_58 = publications.iterator(); enm_58.hasNext(); ) {

          Publication elem_23 = (Publication) enm_58.next();
          pub = (Publication) elem_23;
          {

            Boolean cond_26 = null;
            HashSet var2_28 = new HashSet();
            var2_28 = pub.authors;
            cond_26 = new Boolean(var2_28.contains(a1));
            if (cond_26.booleanValue()) {

              HashSet iset_30 = new HashSet();
              iset_30 = pub.authors;
              Author a3 = null;
              for (Iterator enm_57 = iset_30.iterator(); enm_57.hasNext(); ) {

                Author elem_31 = (Author) enm_57.next();
                a3 = (Author) elem_31;
                {

                  Boolean cond_36 = null;
                  Boolean var1_37 = null;
                  {
                    if ((var1_37 = new Boolean(!UTIL.equals(a3, a2))).booleanValue()) 
                      var1_37 = new Boolean(!UTIL.equals(a3, a1));
                  }
                  {
                    if ((cond_36 = var1_37).booleanValue()) {

                      Boolean var2_44 = null;
                      HashSet var2_46 = new HashSet();
                      HashSet set_48 = new HashSet();
                      Enumeration enm_49 = visited.elements();
                      while ( enm_49.hasMoreElements())
                        set_48.add(enm_49.nextElement());
                      var2_46 = set_48;
                      var2_44 = new Boolean(!var2_46.contains(a3));
                      cond_36 = var2_44;
                    }
                  }
                  if (cond_36.booleanValue()) {

                    Vector tmpArg_v_53 = null;
                    Vector var2_55 = null;
                    var2_55 = new Vector();
                    var2_55.add(a3);
                    tmpArg_v_53 = (Vector) visited.clone();
                    tmpArg_v_53.addAll(var2_55);
                    return pathBetweenAux((Author) a3, (Author) a2, tmpArg_v_53);
                  }
                }
              }
            }
          }
        }
      }
      return new Vector();
    }
    finally {
      sentinel.leaving(((IndexerSentinel) sentinel).pathBetweenAux);
    }
  }
// ***** VDMTOOLS END Name=pathBetweenAux


// ***** VDMTOOLS START Name=pre_pathBetweenAux KEEP=NO
  public Boolean pre_pathBetweenAux (final Author a1, final Author a2, final Vector visited) throws CGException {

    Boolean varRes_4 = null;
    Boolean var1_5 = null;
    {
      if ((var1_5 = new Boolean(!UTIL.equals(a1, a2))).booleanValue()) {

        Boolean var2_9 = null;
        var2_9 = new Boolean(authors.containsKey(a1));
        var1_5 = var2_9;
      }
    }
    {
      if ((varRes_4 = var1_5).booleanValue()) {

        Boolean var2_12 = null;
        var2_12 = new Boolean(authors.containsKey(a2));
        varRes_4 = var2_12;
      }
    }
    return varRes_4;
  }
// ***** VDMTOOLS END Name=pre_pathBetweenAux


// ***** VDMTOOLS START Name=addAuthor KEEP=NO
  public void addAuthor (final Author a) throws CGException {

    if (!this.pre_addAuthor(a).booleanValue()) 
      UTIL.RunTime("Run-Time Error:Precondition failure in addAuthor");
    sentinel.entering(((IndexerSentinel) sentinel).addAuthor);
    try {

      HashMap rhs_2 = new HashMap();
      HashMap var2_4 = new HashMap();
      var2_4 = new HashMap();
      var2_4.put(a, new HashSet());
      {

        HashMap m1_11 = (HashMap) authors.clone();
        HashMap m2_12 = var2_4;
        HashSet com_7 = new HashSet();
        com_7.addAll(m1_11.keySet());
        com_7.retainAll(m2_12.keySet());
        boolean all_applies_8 = true;
        Object d_9;
        for (Iterator bb_10 = com_7.iterator(); bb_10.hasNext() && all_applies_8; ) {

          d_9 = bb_10.next();
          all_applies_8 = m1_11.get(d_9).equals(m2_12.get(d_9));
        }
        if (!all_applies_8) 
          UTIL.RunTime("Run-Time Error:Map Merge: Incompatible maps");
        m1_11.putAll(m2_12);
        rhs_2 = m1_11;
      }
      authors = (HashMap) UTIL.clone(rhs_2);
    }
    finally {
      sentinel.leaving(((IndexerSentinel) sentinel).addAuthor);
    }
  }
// ***** VDMTOOLS END Name=addAuthor


// ***** VDMTOOLS START Name=pre_addAuthor KEEP=NO
  public Boolean pre_addAuthor (final Author a) throws CGException {

    Boolean varRes_2 = null;
    HashSet var2_4 = new HashSet();
    var2_4.clear();
    var2_4.addAll(authors.keySet());
    varRes_2 = new Boolean(!var2_4.contains(a));
    return varRes_2;
  }
// ***** VDMTOOLS END Name=pre_addAuthor


// ***** VDMTOOLS START Name=addAffiliation KEEP=NO
  public void addAffiliation (final Author a, final Affiliation aff) throws CGException {

    if (!this.pre_addAffiliation(a, aff).booleanValue()) 
      UTIL.RunTime("Run-Time Error:Precondition failure in addAffiliation");
    sentinel.entering(((IndexerSentinel) sentinel).addAffiliation);
    try {

      HashSet rhs_3 = new HashSet();
      HashSet var2_7 = new HashSet();
      var2_7 = new HashSet();
      var2_7.add(aff);
      rhs_3 = (HashSet) ((HashSet) authors.get(a)).clone();
      rhs_3.addAll(var2_7);
      authors.put(a, rhs_3);
    }
    finally {
      sentinel.leaving(((IndexerSentinel) sentinel).addAffiliation);
    }
  }
// ***** VDMTOOLS END Name=addAffiliation


// ***** VDMTOOLS START Name=pre_addAffiliation KEEP=NO
  public Boolean pre_addAffiliation (final Author a, final Affiliation aff) throws CGException {

    Boolean varRes_3 = null;
    varRes_3 = new Boolean(authors.containsKey(a));
    return varRes_3;
  }
// ***** VDMTOOLS END Name=pre_addAffiliation


// ***** VDMTOOLS START Name=getAuthorsByAff KEEP=NO
  public HashSet getAuthorsByAff (final Affiliation aff) throws CGException {

    sentinel.entering(((IndexerSentinel) sentinel).getAuthorsByAff);
    try {

      HashSet ret = new HashSet();
      {

        HashSet iset_2 = new HashSet();
        iset_2.clear();
        iset_2.addAll(authors.keySet());
        Author a = null;
        for (Iterator enm_15 = iset_2.iterator(); enm_15.hasNext(); ) {

          Author elem_3 = (Author) enm_15.next();
          a = (Author) elem_3;
          {

            Boolean cond_8 = null;
            cond_8 = new Boolean(((HashSet) authors.get(a)).contains(aff));
            if (cond_8.booleanValue()) 
              ret.add(a);
          }
        }
      }
      return ret;
    }
    finally {
      sentinel.leaving(((IndexerSentinel) sentinel).getAuthorsByAff);
    }
  }
// ***** VDMTOOLS END Name=getAuthorsByAff


// ***** VDMTOOLS START Name=getPublicationsByAuthor KEEP=NO
  public HashSet getPublicationsByAuthor (final Author a) throws CGException {

    if (!this.pre_getPublicationsByAuthor(a).booleanValue()) 
      UTIL.RunTime("Run-Time Error:Precondition failure in getPublicationsByAuthor");
    sentinel.entering(((IndexerSentinel) sentinel).getPublicationsByAuthor);
    try {

      HashSet ret = new HashSet();
      {

        Publication p = null;
        for (Iterator enm_12 = publications.iterator(); enm_12.hasNext(); ) {

          Publication elem_3 = (Publication) enm_12.next();
          p = (Publication) elem_3;
          {

            Boolean cond_6 = null;
            HashSet var2_8 = new HashSet();
            var2_8 = p.authors;
            cond_6 = new Boolean(var2_8.contains(a));
            if (cond_6.booleanValue()) 
              ret.add(p);
          }
        }
      }
      return ret;
    }
    finally {
      sentinel.leaving(((IndexerSentinel) sentinel).getPublicationsByAuthor);
    }
  }
// ***** VDMTOOLS END Name=getPublicationsByAuthor


// ***** VDMTOOLS START Name=pre_getPublicationsByAuthor KEEP=NO
  public Boolean pre_getPublicationsByAuthor (final Author a) throws CGException {

    Boolean varRes_2 = null;
    varRes_2 = new Boolean(authors.containsKey(a));
    return varRes_2;
  }
// ***** VDMTOOLS END Name=pre_getPublicationsByAuthor

}
;
