package com.example.walkthroughscreen.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import com.airbnb.lottie.LottieAnimationView
import com.example.walkthroughscreen.R
import kotlinx.android.synthetic.main.fragment_one.view.*

class FragmentOne : Fragment() {

    private lateinit var title: String
    private lateinit var description: String
    private var imageResource = 0
    private lateinit var tvTitle: AppCompatTextView
    private lateinit var tvDescription: AppCompatTextView
    private lateinit var image: LottieAnimationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (arguments != null) {
            title =
                requireArguments().getString(ARG_PARAM1)!!
            description =
                requireArguments().getString(ARG_PARAM2)!!
            imageResource =
                requireArguments().getInt(ARG_PARAM3)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val rootLayout : View =
         inflater.inflate(R.layout.fragment_one, container, false)

        tvTitle = rootLayout.text_onboarding_title
        tvDescription = rootLayout.text_onboarding_description
        image = rootLayout.image_onboarding
        tvTitle.text = title
        tvDescription.text = description
        image.setAnimation(imageResource)
        return rootLayout
    }

    companion object {

        private const val ARG_PARAM1 = "param1"
        private const val ARG_PARAM2 = "param2"
        private const val ARG_PARAM3 = "param3"

        fun newInstance(
            title: String,
            description: String,
            imageResource: Int
        ): FragmentOne {
            val fragment =
                FragmentOne()
            val args = Bundle()
            args.putString(
                ARG_PARAM1,
                title
            )
            args.putString(
                ARG_PARAM2,
                description
            )
            args.putInt(
                ARG_PARAM3,
                imageResource
            )
            fragment.arguments = args
            return fragment
        }
    }
}