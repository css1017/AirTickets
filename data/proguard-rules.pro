-keepattributes Signature, InnerClasses, EnclosingMethod
-keepattributes RuntimeVisibleAnnotations, RuntimeVisibleParameterAnnotations
-keepattributes AnnotationDefault
-keepclassmembers,allowshrinking,allowobfuscation interface * {
    @retrofit2.http.* <methods>;
}
-dontwarn org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement
-dontwarn javax.annotation.**
-dontwarn kotlin.Unit
-dontwarn retrofit2.KotlinExtensions
-dontwarn retrofit2.KotlinExtensions$*
-if interface * { @retrofit2.http.* <methods>; }
-keep,allowobfuscation interface <1>
-if interface * { @retrofit2.http.* <methods>; }
-keep,allowobfuscation interface * extends <1>
-keep,allowobfuscation,allowshrinking class kotlin.coroutines.Continuation
-if interface * { @retrofit2.http.* public *** *(...); }
-keep,allowoptimization,allowshrinking,allowobfuscation class <3>
-keep,allowobfuscation,allowshrinking class retrofit2.Response

# OkHttp
-keep class okhttp3.** { *; }
-dontwarn okhttp3.**

# Jackson
-keep class com.fasterxml.jackson.** { *; }
-keepclassmembers class * {
    @com.fasterxml.jackson.annotation.* <fields>;
    @com.fasterxml.jackson.annotation.* <methods>;
}
-keepclasseswithmembers class * {
    @com.fasterxml.jackson.databind.annotation.JsonDeserialize <fields>;
}
-keepclasseswithmembers class * {
    @com.fasterxml.jackson.annotation.JsonCreator <methods>;
}
-keep class com.fasterxml.jackson.databind.jsontype.impl.StdTypeResolverBuilder { *; }
-dontwarn java.beans.ConstructorProperties
-dontwarn java.beans.Transient
-dontwarn org.w3c.dom.bootstrap.DOMImplementationRegistry

-keep class com.css101.airtickets.data.models.** { *; }

-keep interface com.css101.airtickets.data.storage.retrofit.TicketService { *; }
-keep class com.css101.airtickets.data.storage.retrofit.RetrofitStorage { *; }
-keep class com.css101.airtickets.data.storage.retrofit.RetrofitInstance { *; }

-keepclassmembers class kotlinx.coroutines.** {*;}
-dontwarn kotlinx.coroutines.**