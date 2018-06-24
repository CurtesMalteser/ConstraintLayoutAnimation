package com.curtesmalteser.constraintlayoutanimation

import android.animation.LayoutTransition
import android.os.Bundle
import android.support.constraint.ConstraintSet
import android.support.transition.Transition
import android.support.transition.TransitionManager
import android.support.v7.app.AppCompatActivity
import android.view.View.GONE
import kotlinx.android.synthetic.main.activity_image_middle.rootMiddle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addAnimationOperations()
        addAnimationToCenter()
        addAnimationToFinal()
        addAnimatioHideMic()
    }

    private fun addAnimationOperations() {
        var set = false
        val constraint1 = ConstraintSet()
        constraint1.clone(root)
        val constraint2 = ConstraintSet()
        constraint2.clone(this, R.layout.activity_image_alt)

        textView.setOnClickListener {
            TransitionManager.beginDelayedTransition(root)
            val constraint = if (set) constraint1 else constraint2
            constraint.applyTo(root)
            addAnimationToCenter()
            set = !set
        }
    }

    private fun addAnimationToCenter() {
        //var set = false
        val constraint1 = ConstraintSet()
        constraint1.clone(root)
        val constraint2 = ConstraintSet()

        constraint2.clone(this, R.layout.activity_image_middle)

        btn.setOnClickListener {
            textView.visibility = GONE
            imageMic.visibility = GONE
            TransitionManager.beginDelayedTransition(root)
            //val constraint = if (set) constraint1 else constraint2
            constraint2.applyTo(root)
            //set = !set
        }
    }

    private fun addAnimationToFinal() {
        // var set = false
        val constraint1 = ConstraintSet()
        constraint1.clone(root)
        val constraint2 = ConstraintSet()

        constraint2.clone(this, R.layout.final_scene)

        imageView.setOnClickListener {
            TransitionManager.beginDelayedTransition(root)
            //   val constraint = if (set) constraint1 else constraint2
            // constraint.applyTo(root)
            constraint2.applyTo(root)
            // set = !set
        }
    }

    private fun addAnimatioHideMic() {
        // var set = false
        val constraint1 = ConstraintSet()
        constraint1.clone(root)
        val constraint2 = ConstraintSet()
        constraint2.clone(this, R.layout.activity_image_alt)

        imageMic.setOnClickListener {
            TransitionManager.beginDelayedTransition(root)
            //    val constraint = if (set) constraint1 else constraint2
            //constraint.applyTo(root)
            constraint2.applyTo(root)
            addAnimationToCenter()
            //  set = !set
        }
    }
}