package com.example.mylibrary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by Konrad on 25.05.2017.
 */

public class Photo {

    public String getPhotoURL() {
        return "images.kuoni.co.uk/73/dubai-39699597-1476718880-ImageGalleryLightboxLarge.jpg";
    }

    ArrayList<String> URLs = new ArrayList<String>(Arrays.asList("http://wf1.xcdn.pl/files/13/01/17/439442_090304_Bytom_03_34.jpg",
            "http://o.aolcdn.com/dims-global/dims3/GLOB/legacy_thumbnail/750x422/quality/95/https://s.blogcdn.com/slideshows/images/slides/493/384/4/S4933844/slug/l/01-bugatti-chiron-fd-1.jpg",
            "http://www.lubanski.eu/wp-content/uploads/2014/11/PeterPan3.jpg", "http://www.polskaatrakcyjna.pl/core/file/image/10020/custom:640x480/image.png"));
    ArrayList<String> URLss = new ArrayList<>();

    public Photo() {
        URLss.add("https://upload.wikimedia.org/wikipedia/commons/c/cf/Zabrze_-_Poczta_G%C5%82%C3%B3wna_01.jpg");
        URLss.add("http://www.vanpur.com.pl/upload/pages/browar-zabrze-943.jpg");
    }

    public String getList() {
        Random los = new Random();
        int wylosowanyIndex = los.nextInt(URLs.size());
        return URLs.get(wylosowanyIndex);


    }
    public String getList2(){
        Random los2 = new Random();
        int wylodsowanyIndex2 = los2.nextInt(URLss.size());
        return URLss.get(wylodsowanyIndex2);
    }
}


