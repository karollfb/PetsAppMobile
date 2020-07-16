package br.com.petsappmobile

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import br.com.petsappmobile.fragments.EmAndamentoFragment
import br.com.petsappmobile.fragments.RealizadosFragment

class MyPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                RealizadosFragment()
            }
            else -> {
                return EmAndamentoFragment()
            }
        }
    }

    override fun getCount(): Int {
        return 2
    }

    override fun getPageTitle(position: Int): CharSequence {
        return when (position) {
            0 -> "Realizados"
            else -> {
                return "Em andamento"
            }
        }
    }
}