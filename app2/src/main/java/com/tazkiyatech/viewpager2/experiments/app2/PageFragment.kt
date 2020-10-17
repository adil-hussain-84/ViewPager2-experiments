package com.tazkiyatech.viewpager2.experiments.app2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_page.*
import java.text.DateFormat
import java.util.*

class PageFragment : Fragment() {

    private var pageNumber: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        pageNumber = arguments?.getInt(PAGE_NUMBER_ARGUMENT) ?: 0
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_page, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val formattedTime = DateFormat.getTimeInstance(DateFormat.MEDIUM).format(Date())

        textView.text = getString(R.string.page_text_format, formattedTime, pageNumber)
    }

    companion object {

        private const val PAGE_NUMBER_ARGUMENT = "page_number"

        @JvmStatic
        fun newInstance(sectionNumber: Int): PageFragment {
            return PageFragment().apply {
                arguments = Bundle().apply {
                    putInt(PAGE_NUMBER_ARGUMENT, sectionNumber)
                }
            }
        }
    }
}