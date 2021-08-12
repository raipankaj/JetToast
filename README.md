# JetToast
[![](https://jitpack.io/v/raipankaj/JetToast.svg)](https://jitpack.io/#raipankaj/JetToast)

Show highly customizable toast messages in your app built with Jetpack Compose.

Now with Jetpack Compose you can easily add toast to your existing app within 5 lines of code.

To get started with JetToast just add the maven url and the dependency

<b>build.gradle (Project level)</b>
```groovy
allprojects {
    repositories {
    ...
    //Add this url
    maven { url 'https://jitpack.io' }
    }
}
```
If you are using Android Studio Arctic Fox and do not have allProjects in build.gradle then add following maven url in <b>settings.gradle</b> like below
```groovy
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        //Add this url
        maven { url 'https://jitpack.io' }
        jcenter() // Warning: this repository is going to shut down soon
    }
}
```

Once you have added the maven url now add the Stories dependency in the <b>build.gradle (module level)</b>
```groovy
implementation 'com.github.raipankaj:JetToast:0.1.0'
```

Congratulations, you have successfully added the dependency. 
Now to get started with JetToast add the following code snippet
```kotlin
var showToast by remember {
    mutableStateOf(false)
}

Toast(
    message = "Simple Toast",
    showToast = showToast,
    afterToastShown = { showToast = it }
)
```
<br>
Toast composable provides an ability to change text color, background color, width, shape, enter/exit animation and many more options to customize the toast message.
Here are all the parameters accepted by Toast composable.

```kotlin
@Composable
fun Toast(
    message: String,
    showToast: Boolean, afterToastShown: (Boolean) -> Unit,
    toastDelay: ToastDelay = ToastDelay.ShortDelay,
    shape: Shape = CircleShape,
    background: Color = Color.Gray,
    textColor: Color = Color.White,
    alignment: Alignment = Alignment.BottomCenter,
    fillMaxWidth: Boolean = false,
    leadingIconSpace: Dp = 0.dp,
    trailingIconSpace: Dp = 0.dp,
    disableAutoHide: Boolean = false,
    leadingContent: (@Composable () -> Unit)? = null,
    trailingContent: (@Composable () -> Unit)? = null,
    enter: EnterTransition = fadeIn(animationSpec = tween(500, easing = LinearEasing)),
    exit: ExitTransition = fadeOut(animationSpec = tween(500, easing = LinearEasing)),
)
```

</br>
Here is a code snippet to show default toast

```kotlin
@Composable
fun DefaultToast() {
    var showToast by remember {
        mutableStateOf(false)
    }

    Column(Modifier.height(80.dp)) {

        Text("Default Toast", Modifier.fillMaxWidth().clickable {
                showToast = true
        }, textAlign = TextAlign.Center)
        Toast(
            message = "Simple Toast",
            showToast = showToast,
            afterToastShown = { showToast = it },
        )
    }
}
```

<br>
You can also show toast like a snackbar

```kotlin
@Composable
fun FixedUntilClickToast() {
    var showToast by remember {
        mutableStateOf(false)
    }

    Column(Modifier.height(80.dp)) {

        Text("Fixed Until Click Toast", Modifier.fillMaxWidth().clickable {
            showToast = true
        }, textAlign = TextAlign.Center)
        Toast(
            message = "Fixed Until Click Toast",
            showToast = showToast,
            afterToastShown = { showToast = it },
            background = Color.Black,
            trailingIconSpace = 4.dp,
            disableAutoHide = true,
            fillMaxWidth = true,
            shape = RectangleShape,
            trailingContent = {
               Text(text = "OK", modifier = Modifier.clickable { showToast = false },
               color = Color.White)
            }
        )
    }
}
```
<br>
Here are all the supported types of Toast

[![Demo](https://github.com/raipankaj/JetToast/blob/main/ToastsSmall.png)](https://youtu.be/d0_tH6FfWuo)

<br>
Note: If you like this library, then please hit the star button! :smiley:

