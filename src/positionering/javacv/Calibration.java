
package positionering.javacv;

/**
 *
 * @author Dion
 */
public class Calibration {

    private static final String pink_good = "C:/Imtech/Posipics/calibrate/pink_good.jpg";
    private static final String pink_bad = "C:/Imtech/Posipics/calibrate/pink_bad.jpg";
    private static final String orange_good = "C:/Imtech/Posipics/calibrate/orange_good.jpg";
    private static final String orange_bad = "C:/Imtech/Posipics/calibrate/orange_bad.jpg";
    private static final String blue_good = "C:/Imtech/Posipics/calibrate/blue_good.jpg";
    private static final String blue_bad = "C:/Imtech/Posipics/calibrate/blue_bad.jpg";
    private static final String yellow_good = "C:/Imtech/Posipics/calibrate/yellow_good.jpg";
    private static final String yellow_bad = "C:/Imtech/Posipics/calibrate/yellow_bad.jpg";
    private static final String green_good = "C:/Imtech/Posipics/calibrate/green_good.jpg";
    private static final String green_bad = "C:/Imtech/Posipics/calibrate/green_bad.jpg";
    private static final String beige_good = "C:/Imtech/Posipics/calibrate/beige_good.jpg";
    private static final String beige_bad = "C:/Imtech/Posipics/calibrate/beige_bad.jpg";
    private static final String purple_good = "C:/Imtech/Posipics/calibrate/purple_good.jpg";
    private static final String purple_bad = "C:/Imtech/Posipics/calibrate/purple_bad.jpg";
    private static final String cyan_good = "C:/Imtech/Posipics/calibrate/cyan_good.jpg";
    private static final String cyan_bad = "C:/Imtech/Posipics/calibrate/cyan_bad.jpg";
    public static int[] pink_bgr = new int[6];
    public static int[] yellow_bgr = new int[6];
    public static int[] orange_bgr = new int[6];
    public static int[] blue_bgr = new int[6];
    public static int[] green_bgr = new int[6];
    public static int[] cyan_bgr = new int[6];
    public static int[] beige_bgr = new int[6];
    public static int[] purple_bgr = new int[6];

    public static void calibrate() {
        ImageFilter.clear();
        int i = 0;
        ImageFilter.filter(pink_good);
        for (int k : ImageFilter.getBGRBounds()) {
            if (k > 255) {
                pink_bgr[i] = 255;
            } else {
                pink_bgr[i] = k;
            }
            i++;
        }
        ImageFilter.clear();
        i = 0;
        ImageFilter.filter(pink_bad);
        for (int k : ImageFilter.getBGRBounds()) {
            if (i < 3 && pink_bgr[i] > k) {
                if (k < 0) {
                    pink_bgr[i] = 0;
                } else {
                    pink_bgr[i] = k;
                }
            } else if (i >= 3 && pink_bgr[i] < k) {
                if (k > 255) {
                    pink_bgr[i] = 255;
                } else {
                    pink_bgr[i] = k;
                }
            }
            i++;
        }
        ImageFilter.clear();
        i = 0;
        ImageFilter.filter(yellow_good);
        for (int k : ImageFilter.getBGRBounds()) {
            if (k > 255) {
                yellow_bgr[i] = 255;
            } else {
                yellow_bgr[i] = k;
            }
            i++;
        }
        ImageFilter.clear();
        i = 0;
        ImageFilter.filter(yellow_bad);
        for (int k : ImageFilter.getBGRBounds()) {
            if (i < 3 && yellow_bgr[i] > k) {
                if (k < 0) {
                    yellow_bgr[i] = 0;
                } else {
                    yellow_bgr[i] = k;
                }
            } else if (i >= 3 && yellow_bgr[i] < k) {
                if (k > 255) {
                    yellow_bgr[i] = 255;
                } else {
                    yellow_bgr[i] = k;
                }
            }
            i++;
        }
        ImageFilter.clear();
        i = 0;
        ImageFilter.filter(blue_good);
        for (int k : ImageFilter.getBGRBounds()) {
            if (k > 255) {
                blue_bgr[i] = 255;
            } else {
                blue_bgr[i] = k;
            }
            i++;
        }
        ImageFilter.clear();
        i = 0;
        ImageFilter.filter(blue_bad);
        for (int k : ImageFilter.getBGRBounds()) {
            if (i < 3 && blue_bgr[i] > k) {
                if (k < 0) {
                    blue_bgr[i] = 0;
                } else {
                    blue_bgr[i] = k;
                }
            } else if (i >= 3 && blue_bgr[i] < k) {
                if (k > 255) {
                    blue_bgr[i] = 255;
                } else {
                    blue_bgr[i] = k;
                }
            }
            i++;
        }
        ImageFilter.clear();
        i = 0;
        ImageFilter.filter(orange_good);
        for (int k : ImageFilter.getBGRBounds()) {
            if (k > 255) {
                orange_bgr[i] = 255;
            } else {
                orange_bgr[i] = k;
            }
            i++;
        }
        ImageFilter.clear();
        i = 0;
        ImageFilter.filter(orange_bad);
        for (int k : ImageFilter.getBGRBounds()) {
            if (i < 3 && orange_bgr[i] > k) {
                if (k < 0) {
                    orange_bgr[i] = 0;
                } else {
                    orange_bgr[i] = k;
                }
            } else if (i >= 3 && orange_bgr[i] < k) {
                if (k > 255) {
                    orange_bgr[i] = 255;
                } else {
                    orange_bgr[i] = k;
                }
            }
            i++;
        }
        ImageFilter.clear();
        i = 0;
        ImageFilter.filter(green_good);
        for (int k : ImageFilter.getBGRBounds()) {
            if (k > 255) {
                green_bgr[i] = 255;
            } else {
                green_bgr[i] = k;
            }
            i++;
        }
        ImageFilter.clear();
        i = 0;
        ImageFilter.filter(green_bad);
        for (int k : ImageFilter.getBGRBounds()) {
            if (i < 3 && green_bgr[i] > k) {
                if (k < 0) {
                    green_bgr[i] = 0;
                } else {
                    green_bgr[i] = k;
                }
            } else if (i >= 3 && green_bgr[i] < k) {
                if (k > 255) {
                    green_bgr[i] = 255;
                } else {
                    green_bgr[i] = k;
                }
            }
            i++;
        }
        ImageFilter.clear();
        i = 0;
        ImageFilter.filter(beige_good);
        for (int k : ImageFilter.getBGRBounds()) {
            if (k > 255) {
                beige_bgr[i] = 255;
            } else {
                beige_bgr[i] = k;
            }
            i++;
        }
        ImageFilter.clear();
        i = 0;
        ImageFilter.filter(beige_bad);
        for (int k : ImageFilter.getBGRBounds()) {
            if (i < 3 && beige_bgr[i] > k) {
                if (k < 0) {
                    beige_bgr[i] = 0;
                } else {
                    beige_bgr[i] = k;
                }
            } else if (i >= 3 && beige_bgr[i] < k) {
                if (k > 255) {
                    beige_bgr[i] = 255;
                } else {
                    beige_bgr[i] = k;
                }
            }
            i++;
        }
        ImageFilter.clear();
        i = 0;
        ImageFilter.filter(purple_good);
        for (int k : ImageFilter.getBGRBounds()) {
            if (k > 255) {
                purple_bgr[i] = 255;
            } else {
                purple_bgr[i] = k;
            }
            i++;
        }
        ImageFilter.clear();
        i = 0;
        ImageFilter.filter(purple_bad);
        for (int k : ImageFilter.getBGRBounds()) {
            if (i < 3 && purple_bgr[i] > k) {
                if (k < 0) {
                    purple_bgr[i] = 0;
                } else {
                    purple_bgr[i] = k;
                }
            } else if (i >= 3 && purple_bgr[i] < k) {
                if (k > 255) {
                    purple_bgr[i] = 255;
                } else {
                    purple_bgr[i] = k;
                }
            }
            i++;
        }
        ImageFilter.clear();
        i = 0;
        ImageFilter.filter(cyan_good);
        for (int k : ImageFilter.getBGRBounds()) {
            if (k > 255) {
                cyan_bgr[i] = 255;
            } else {
                cyan_bgr[i] = k;
            }
            i++;
        }
        ImageFilter.clear();
        i = 0;
        ImageFilter.filter(cyan_bad);
        for (int k : ImageFilter.getBGRBounds()) {
            if (i < 3 && cyan_bgr[i] > k) {
                if (k < 0) {
                    cyan_bgr[i] = 0;
                } else {
                    cyan_bgr[i] = k;
                }
            } else if (i >= 3 && cyan_bgr[i] < k) {
                if (k > 255) {
                    cyan_bgr[i] = 255;
                } else {
                    cyan_bgr[i] = k;
                }
            }
            i++;
        }
    }
}
