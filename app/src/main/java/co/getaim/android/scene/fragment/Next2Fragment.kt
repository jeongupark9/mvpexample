package co.getaim.android.scene.fragment

import android.os.Bundle
import android.util.Log
import android.view.View
import co.getaim.android.base.BaseFragment
import com.example.mvpmodeltest.R
import kotlinx.android.synthetic.main.f_next_2.*

class Next2Fragment : BaseFragment(){
    override fun getViewResourceID(): Int  =
        R.layout.f_next_2

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        f_next_2_text_next.setOnClickListener {
        }
        f_next_2_btn_before.setOnClickListener {
            popFragment()
        }
    }

}