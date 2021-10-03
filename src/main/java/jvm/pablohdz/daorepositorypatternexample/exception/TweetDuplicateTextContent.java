package jvm.pablohdz.daorepositorypatternexample.exception;

public class TweetDuplicateTextContent
        extends RuntimeException {
    public TweetDuplicateTextContent(String message) {
        super(message);
    }
}
