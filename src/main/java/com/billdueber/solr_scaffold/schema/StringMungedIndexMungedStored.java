package com.billdueber.solr_scaffold.schema;

import org.apache.solr.schema.IndexSchema;
import org.apache.solr.schema.StrField;
import org.apache.solr.schema.TextField;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.Map;

public class StringMungedIndexMungedStored extends StrField {

  private static final Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
  protected Boolean echoInvalidInput = false;
  public IndexSchema sch;
  public String munged;

  protected void init(IndexSchema schema, Map<String, String> args) {
    super.init(schema, args);
    this.sch = schema;
    String p = args.remove("echoInvalidInput");
    if (p != null) {
      this.echoInvalidInput = Boolean.parseBoolean(p);
    }
  }

  public String munge(String str) {
    return str;
  }

  @Override
  public String toInternal(String val) {
    String fieldName = "upperA";
    TextField ft = (TextField) sch.getFieldType(fieldName);
    String s = TextField.analyzeMultiTerm(fieldName, val, ft.getIndexAnalyzer()).utf8ToString();

    log.warn("ft is " + ft.toString());
    log.warn("Token is " + s);

//    TokenizerChain a = (TokenizerChain) ft.getIndexAnalyzer();
//    log.warn("Analyzer is " + a.toString());
//    String a1 = a.normalize(fieldName, val).utf8ToString();
//    TokenStream ts = a.tokenStream(fieldName, val);
//    log.warn("tokenstream is " + ts.toString());
//    TokenFilterFactory tff = a.getTokenFilterFactories()[0];
//    log.warn("TFF is " + tff.toString());
//
//
//    TokenStream ts1 = tff.normalize(ts);
//    CharTermAttribute cta = ts.getAttribute(CharTermAttribute.class);
//    log.warn("ts1 is " + ts1.toString());
//    try {
//      ts1.reset();
//      Boolean had_token = ts1.incrementToken();
//      ts1.end();
//      ts1.close();
//    } catch (IOException e) {
//      e.printStackTrace();
//    }
//    log.warn("First token is " + cta.toString());



    munged = munge(val);
    if (munged == null && echoInvalidInput) {
      munged = val;
    }

    return munged;
  }

}
