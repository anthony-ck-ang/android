# AndroidStudio
Having some fun coding on Android Studios. :smile: :white_check_mark:

These are some basic practices that I have been doing.

#### FLICKR Browser app 
```
    Retrieve and display a list of pictures and details from FLICKR based on your search query
```   
![pt2017_11_03_14_40_47](https://user-images.githubusercontent.com/28585087/32362546-21f57830-c0a5-11e7-80ef-74d32cff11fc.jpg)

#### otherLang app
```
    Present (in text) and play (audio) common words from different catergories, in default and an other language through multiple screens
```   
![pt2017_11_03_21_19_25](https://user-images.githubusercontent.com/28585087/32375523-e8026682-c0dc-11e7-8e91-c2108b715b34.jpg)
#### Adopt a pet app
```
    Display different views (with ratings) of cute furry animals up for adoption
```   


#### Comedian Bot app
```
    Randomly picks and tell a joke in the console
```

## Setting up Android Studios

1. Install [Android studios](https://developer.android.com/studio/index.html?gclid=Cj0KCQjwvabPBRD5ARIsAIwFXBkZI0ZKf-1QBM2wcMIk7tRwd-6ZV_uzZSnkhSBGHgyqTRtpyXM7xkAaAo9kEALw_wcB).
   - Configure the IDE accordingly based on [User Guide](https://developer.android.com/studio/intro/index.html) (if required)

## For Testing FlickrBrowser_app_v0.3.1_stable_version
2. Open Terminal 
```
   - cd <directory of choice>
   - git clone <this repository's URL> to your local directory/repository
```
3. Open Android Studios 
   - Select 'Open an existing Android Studio project'
     - Navigate and choose the cloned project (file) from your directory
      - Run (Green arrow button) with either:
        - GenyMotion
        - Existing Android mobile device (Connect it to your machine with a USB cable)
          - Choose your device name under 'Connected Device' (When menu pops up) 
       
## For project with src folder only (Manually)
4. Start a new Android Studio Project
   - Download the file as a zip
   - Unzip and navigate to the project you want to work with
   - Copy the src folder and replace the existing src folder created in your "Start a new Android Studio Project"

## For Gradle Configuration

1. In Android Studios, navigate to the Android tab
2. Under Gradle Scripts, open build.gradle(Module:app)

Ensure the following dependencies are added:
```
    compile fileTree(include: ['*.jar'], dir: 'libs')
    testCompile 'junit:junit:4.12'
    compile 'com.android.support:design:23.4.0'
    compile 'com.android.support:appcompat-v7:23.4.0'
    compile 'com.android.support:cardview-v7:23.4.0'
    compile 'com.android.support:recyclerview-v7:23.4.0 '
    compile 'com.squareup.picasso:picasso:2.5.2'
```
  




