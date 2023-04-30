package conceptual;

import java.util.Arrays;

public class SentimentAnalyzer {
    public static int[] detectProsAndCons(String review, String[][] featureSet, String[] posOpinionWords, String[] negOpinionWords) {
        int[] featureOpinions = new int[featureSet.length];
        review = review.toLowerCase();
        loop:
        for (int i = 0; i < featureSet.length; i++) {
            for (int j = 0; j < featureSet[i].length; j++) {
                if (review.contains(featureSet[i][j])) {
                    int response = getOpinionOnFeature(review, featureSet[i][j], posOpinionWords, negOpinionWords);
                    featureOpinions[i] = response;
                    continue loop;
                }
            }
        }
        return featureOpinions;
    }

    private static int getOpinionOnFeature(String review, String feature, String[] posOpinionWords, String[] negOpinionWords) {
        int response = checkForWasPhrasePattern(review, feature, posOpinionWords, negOpinionWords);
        if (response == 0) response = checkForOpinionFirstPattern(review, feature, posOpinionWords, negOpinionWords);
        return response;
    }

    private static int checkForWasPhrasePattern(String review, String feature, String[] posOpinionWords, String[] negOpinionWords) {
        int opinion = 0;
        String pattern = feature + " was ";

        if (review.contains(pattern)) {
            String featureSearch = review.substring(review.indexOf(pattern) + pattern.length());
            for (String pos : posOpinionWords) {
                if (featureSearch.contains(pos)) return 1;
            }
            for (String neg : negOpinionWords) {
                if (featureSearch.contains(neg)) return -1;
            }
        }
        return opinion;
    }

    private static int checkForOpinionFirstPattern(String review, String feature, String[] posOpinionWords, String[] negOpinionWords) {
        String pattern = " " + feature;
        int opinion = 0;
        if (review.contains(pattern)) {
            String substring = review.substring(0, review.indexOf(pattern));
            for (String pos : posOpinionWords) {
                if (substring.endsWith(pos)) return 1;
            }
            for (String neg : negOpinionWords) {
                if (substring.endsWith(neg)) return -1;
            }
        }
        return opinion;
    }

    public static void main(String[] args) {
//        String review = "Haven't been here in years! Fantastic service and the food was delicious! Definitely will be a frequent flyer! Francisco was very attentive";

        String review = "Sorry OG, but you just lost some loyal customers. Horrible service, no smile or greeting just attitude. The bread sticks were stale and burnt, appetizer was cold and the food came out before the salad.";

        String[][] featureSet = {{"ambiance", "ambience", "atmosphere", "decor"}, {"dessert", "ice cream", "desert"}, {"food"}, {"soup"}, {"service", "management", "waiter", "waitress", "bartender", "staff", "server"}};
        String[] posOpinionWords = {"good", "fantastic", "friendly", "great", "excellent", "amazing", "awesome", "delicious"};
        String[] negOpinionWords = {"slow", "bad", "horrible", "awful", "unprofessional", "poor"};

        int[] featureOpinions = detectProsAndCons(review, featureSet, posOpinionWords, negOpinionWords);
        System.out.println("Opinions on Features: " + Arrays.toString(featureOpinions));
    }
}