package com.udacity.webcrawler.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

/**
 * A static utility class that loads a JSON configuration file.
 */
public final class ConfigurationLoader {

  private final Path path;

  /**
   * Create a {@link ConfigurationLoader} that loads configuration from the given {@link Path}.
   */
  public ConfigurationLoader(Path path) {
    this.path = Objects.requireNonNull(path);
  }

  /**
   * Loads configuration from this {@link ConfigurationLoader}'s path
   *
   * @return the loaded {@link CrawlerConfiguration}.
   */
  public CrawlerConfiguration load(){
    // TODO: Fill in this method.
    try(BufferedReader reader = Files.newBufferedReader(this.path)){
//      read(reader);
      return read(reader);
    }catch (IOException e){
        e.printStackTrace();
        return null;
    }
//    return new CrawlerConfiguration.Builder().build();
  }

  /**
   * Loads crawler configuration from the given reader.
   *
   * @param reader a Reader pointing to a JSON string that contains crawler configuration.
   * @return a crawler configuration
   */
  public static CrawlerConfiguration read(Reader reader) throws IOException {
    // This is here to get rid of the unused variable warning.
    Objects.requireNonNull(reader);
    // TODO: Fill in this method
    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.disable(JsonParser.Feature.AUTO_CLOSE_SOURCE);
    try{
      CrawlerConfiguration crawlerConfiguration = objectMapper.readValue(reader, CrawlerConfiguration.class);
      return crawlerConfiguration;
    } catch (IOException e){
      e.printStackTrace();
      throw e;
    }


//    return new CrawlerConfiguration.Builder()
//            .addStartPages(String.valueOf(crawlerConfiguration.getStartPages()))
//            .addIgnoredUrls(String.valueOf(crawlerConfiguration.getIgnoredUrls()))
//            .addIgnoredWords(String.valueOf(crawlerConfiguration.getIgnoredWords()))
//            .setParallelism(crawlerConfiguration.getParallelism())
//            .setImplementationOverride(String.valueOf(crawlerConfiguration.getImplementationOverride()))
//            .setMaxDepth(crawlerConfiguration.getMaxDepth())
//            .setTimeoutSeconds(crawlerConfiguration.getTimeout().toSecondsPart())
//            .setPopularWordCount(crawlerConfiguration.getPopularWordCount())
//            .setProfileOutputPath(String.valueOf(crawlerConfiguration.getProfileOutputPath()))
//            .setResultPath(String.valueOf(crawlerConfiguration.getResultPath()))
//            .build();
  }
}
