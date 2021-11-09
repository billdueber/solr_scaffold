package com.billdueber.solr_scaffold.analysis.example;

import com.billdueber.solr_scaffold.analysis.SimpleFilterFactory;
import org.apache.lucene.analysis.TokenStream;

import java.util.Map;

/**
 * You should be able to just search-and-replace SmileyFilter with whatever your
 * filter is called and leave everything else alone.
 */
public class SmileyFilterFactory extends SimpleFilterFactory {

  public SmileyFilterFactory(Map<String, String> args) {
    super(args);
  }

  public SmileyFilter create(TokenStream input) {
    return new SmileyFilter(input, getEchoInvalidInput());
  }
}
