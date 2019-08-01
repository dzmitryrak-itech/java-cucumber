package utils;

public class URLUtils {

    /**
     *
     * @param url, e.g. https://seniorlink--staging.lightning.force.com/lightning/r/Contact/0031800000a8bLzAAI/view
     * @return objectId, e.g. 0031800000a8bLzAAI
     */
    public String getIDFromURL(String url){
        //https://seniorlink--devdzmitry.lightning.force.com/lightning/r/Contact/0030q00000LzbKNAAZ/view
        return url.split("/")[6];
    }
}
