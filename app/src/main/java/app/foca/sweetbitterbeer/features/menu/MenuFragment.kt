package app.foca.sweetbitterbeer.features.menu


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider

import app.foca.sweetbitterbeer.R
import app.foca.sweetbitterbeer.databinding.FragmentMenuBinding
import app.foca.sweetbitterbeer.di.Injectable
import app.foca.sweetbitterbeer.features.menu.viewModel.MenuViewModel
import app.foca.sweetbitterbeer.utils.viewModel.injectViewModel
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 */
class MenuFragment : Fragment(), Injectable {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewModel: MenuViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = injectViewModel(viewModelFactory)
        val binding = DataBindingUtil.inflate<FragmentMenuBinding>(
            inflater, R.layout.fragment_menu, container, false)

        return binding.root
    }


}
