# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile

########################################
# Core: keep useful attributes
########################################
-keepattributes *Annotation*, Signature, InnerClasses, EnclosingMethod

# Keep Android Parcelable CREATOR fields
-keepclassmembers class * implements android.os.Parcelable {
    public static final android.os.Parcelable$Creator CREATOR;
}

# Keep native method names (JNI)
-keepclasseswithmembernames class * {
    native <methods>;
}

# Keep Serializable machinery (if you use java.io.Serializable)
-keepclassmembers class * implements java.io.Serializable {
    static final long serialVersionUID;
    private static final java.io.ObjectStreamField[] serialPersistentFields;
    private void writeObject(java.io.ObjectOutputStream);
    private void readObject(java.io.ObjectInputStream);
    private void readObjectNoData();
}

########################################
# Safer, explicit keeps via @Keep
# (Recommended: annotate only what's needed)
########################################
-keep @androidx.annotation.Keep class * { *; }
-keepclassmembers class * {
    @androidx.annotation.Keep *;
}

########################################
# Logging & debug (optional)
########################################
# Strip Log calls in release (R8 can do this via rules or by const folding)
#-assumenosideeffects class android.util.Log {
#    public static *** d(...);
#    public static *** v(...);
#    public static *** i(...);
#    public static *** w(...);
#}

########################################
# Kotlin (R8 already understands Kotlin metadata)
########################################
# (No required rules; attributes above are enough)
-keep class com.yourapp.model.** { *; }
-keepclassmembers class ** {
  @com.google.gson.annotations.SerializedName <fields>;
}

-keepattributes Signature
-keep class com.squareup.moshi.** { *; }
-keep class kotlin.Metadata { *; }
# Keep your JsonClass models if using reflection (not codegen):
# Only if you see specific harmless warnings:
# -dontwarn javax.annotation.**
