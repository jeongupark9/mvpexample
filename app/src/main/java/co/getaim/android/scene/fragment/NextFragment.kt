package co.getaim.android.scene.fragment

import android.os.Bundle
import android.util.Log
import android.view.View
import co.getaim.android.base.BaseFragment
import com.example.mvpmodeltest.R
import kotlinx.android.synthetic.main.f_next.*

class NextFragment : BaseFragment(){
    override fun getViewResourceID(): Int  =
        R.layout.f_next

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        f_next_btn_next.setOnClickListener {
            pushFragment(Next2Fragment())
        }
        f_next_text_next.setOnClickListener {
            Log.d("PARK", "TopFragment: ${getTopFragmnet()}")
        }
        f_next_btn_before.setOnClickListener {
            popFragment()
        }
    }

    override fun onReturn() {
        Log.d("PARK", "onNext onReturn call")
        super.onReturn()

    }
}