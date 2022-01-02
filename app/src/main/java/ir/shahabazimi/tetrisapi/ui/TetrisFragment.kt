package ir.shahabazimi.tetrisapi.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ir.shahabazimi.tetrisapi.R
import ir.shahabazimi.tetrisapi.databinding.FragmentTetrisBinding

class TetrisFragment : Fragment() {

    private lateinit var b:FragmentTetrisBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        b= FragmentTetrisBinding.inflate(inflater, container, false)
        return b.root
    }

}