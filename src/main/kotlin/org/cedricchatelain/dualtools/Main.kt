package org.cedricchatelain.dualtools

import javafx.beans.property.SimpleStringProperty
import tornadofx.*

class Main : App(MyView1::class) {
}

//class MainView : View() {
//    override val root = vbox {
//        button("Press the button")
//        label("Waiting")
//    }
//}

class MyView1: View() {
    override val root = vbox {
        label("View 1")
        button("Go to MyView2") {
            action {
                replaceWith(MyView2::class, ViewTransition.Slide(0.3.seconds, ViewTransition.Direction.RIGHT))
            }
        }
    }

    override fun onDock() {
        println("Docking MyView1!")
    }

    override fun onUndock() {
        println("Undocking MyView1!")
    }
}

class MyView2: View() {
    override val root = vbox {
        label("View 2")
        button("Go to MyView1") {
            action {
                replaceWith(MyView1::class, ViewTransition.Slide(0.3.seconds, ViewTransition.Direction.LEFT))
            }
        }
    }
    override fun onDock() {
        println("Docking MyView2!")
    }
    override fun onUndock() {
        println("Undocking MyView2!")
    }
}
	
