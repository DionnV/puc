
package positionering.javacv;

//static imports
import static com.googlecode.javacv.cpp.opencv_core.*;
import static com.googlecode.javacv.cpp.opencv_highgui.cvLoadImage;
import static com.googlecode.javacv.cpp.opencv_highgui.cvSaveImage;
import static com.googlecode.javacv.cpp.opencv_imgproc.*;
import positionering.etc.Point;

/** This class contains sourcecode to filter an image given a BGR range.
 *
 * @author Dion
 */
public class TargetFinder {
       
    private CvScalar min = cvScalar(0,0,0,0);//BGR-A
    private CvScalar max = cvScalar(255.0, 255.0, 255.0, 0.0);//BGR-A
    
    private int posX = 0;
    private int posY = 0;
    
    /** Creates a TargetFinder object.
     * 
     */
    public TargetFinder() {
    }

    /** This method filters out all the color which are not in the given range.
     *  It will then calculate the center of the remaining pixels and return
     *  a Point object.
     * 
     * @param filename the path to the file.
     * @return a Point object.
     */
    public Point detectPosition(String filename) {
        IplImage image = cvLoadImage(filename);
        if (image != null) {
            //create binary image of original size
            IplImage imgThreshold = cvCreateImage(cvGetSize(image), 8, 1);

            //apply thresholding
            cvInRangeS(image, min, max, imgThreshold);

            //smooth the image
            cvSmooth(image, image, CV_GAUSSIAN, 3);

            //release image from the memory
            cvReleaseImage(image);

            //initialize moments
            CvMoments moments = new CvMoments();
            cvMoments(imgThreshold, moments, 1);

            // cv Spatial moment : Mji=sumx,y(I(x,y)•xj•yi)
            // where I(x,y) is the intensity of the pixel (x, y).
            double momX10 = cvGetSpatialMoment(moments, 1, 0); // (x,y)
            double momY01 = cvGetSpatialMoment(moments, 0, 1);// (x,y)
            double area = cvGetCentralMoment(moments, 0, 0);

            //calculate position points
            posX = (int) (momX10 / area);
            posY = (int) (momY01 / area);
        }
        return new Point(posX, posY);
    }
    
    /** Sets the target color.
     * 
     * @param min minimal range as in [blue, green, red, 0]
     * @param max maximal range as in [blue, green, red, 0]
     */
    public void setTargetColor(int[] min, int[] max){
        this.min = cvScalar(min[0], min[1], min[2], min[3]);//BGR-A
        this.max = cvScalar(max[0], max[1], max[2], max[3]);//BGR-A
    }
    
    /** Loads a file, thresholds it and then saves it.
     *  This method is only used for testing purposes.
     * 
     * @param filename the path to the filename.
     */
    public void loadAndSave(String filename){
        IplImage image = cvLoadImage(filename);    
        if (image != null) {
            //create binary image of original size
            IplImage imgThreshold = cvCreateImage(cvGetSize(image), 8, 1);

            //apply thresholding
            cvInRangeS(image, min, max, imgThreshold);

            //smooth the image
            cvSmooth(image, image, CV_GAUSSIAN, 3);

            //Just for testing
            cvSaveImage("C:/Imtech/Posipics/filtered.jpg", imgThreshold);

            //release image from the memory
            cvReleaseImage(image);
        }
    }
}
