package com.billdueber.solr_scaffold.analysis;

import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.util.TokenFilterFactory;

import java.lang.reflect.*;
import java.util.Map;

public class MungeSingleTokenFilterFactory extends TokenFilterFactory {
  private Boolean echoInvalidInput;

  public MungeSingleTokenFilterFactory(Map<String, String> args) {
    super(args);
    echoInvalidInput = getBoolean(args, "echoInvalidInput", false);
  }

  public Boolean getEchoInvalidInput() {
    return echoInvalidInput;
  }

  public MungeSingleTokenFilter create(TokenStream input) {
    return new MungeSingleTokenFilter(input, echoInvalidInput);
  }

}
