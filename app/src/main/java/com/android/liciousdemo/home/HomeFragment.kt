package com.android.liciousdemo.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.android.liciousdemo.R
import com.android.liciousdemo.databinding.FragmentHomeBinding
import com.android.liciousdemo.di.ViewModelFactory
import com.android.liciousdemo.model.Filter
import com.android.newsapp.di.Injectable
import javax.inject.Inject

class HomeFragment : Fragment(), Injectable, View.OnClickListener {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private lateinit var homeAdapter: HomeRecyclerAdapter
    private lateinit var binding: FragmentHomeBinding
    private val filters = mutableListOf<Filter>()

    private val homeViewModel by viewModels<HomeViewModel> {
        viewModelFactory
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.filter1.setOnClickListener(this)
        binding.filter2.setOnClickListener(this)
        binding.filter1.isSelected=true
        subscribeOnUi()
        with(binding.productList) {
            homeAdapter = HomeRecyclerAdapter()
            addItemDecoration(
                SpaceItemDecoration(
                    resources.getDimension(R.dimen.size_8).toInt()
                )
            )
            adapter = homeAdapter
        }
    }

    private fun subscribeOnUi() {
        homeViewModel.result.observe(viewLifecycleOwner, Observer {
            homeAdapter.setData(it)
        })
        homeViewModel.filters.observe(viewLifecycleOwner, Observer {
            filters.clear()
            filters.addAll(it)
            if (it.size > 1) {
                val filter1 = it[0]
                val filter2 = it[1]
                binding.filter1.text = filter1.title
                binding.filter2.text = filter2.title
            }
        })
    }

    companion object {

        /**
         * Returns a new instance of this fragment for the given source
         * id.
         */
        @JvmStatic
        fun newInstance(): HomeFragment {
            return HomeFragment()
        }
    }

    override fun onClick(v: View?) {
        v?.id?.let {
            when (it) {
                R.id.filter1 -> {
                    binding.filter1.isSelected = true
                    binding.filter2.isSelected = false
                    if (filters.isNotEmpty())
                        homeViewModel.filterExpressDeliverProducts(filters[0].type)
                }
                R.id.filter2 -> {
                    binding.filter2.isSelected = true
                    binding.filter1.isSelected = false
                    if (filters.size > 1)
                        homeViewModel.filterExpressDeliverProducts(filters[1].type)
                }
            }
        }
    }

}