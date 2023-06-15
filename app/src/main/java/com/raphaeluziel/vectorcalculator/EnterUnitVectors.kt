package com.raphaeluziel.vectorcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import com.raphaeluziel.vectorcalculator.databinding.ActivityEnterUnitVectorsBinding


private const val TAG = "MainActivity"


class EnterUnitVectors : AppCompatActivity() {

    private lateinit var binding: ActivityEnterUnitVectorsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEnterUnitVectorsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val vectorA = Vector()
        val vectorB = Vector()

        val vectorInputs:HashMap<EditText, String> = hashMapOf(
            binding.scaleA to "as", binding.aiInput to "ai", binding.ajInput to "aj", binding.akInput to "ak",
            binding.scaleB to "bs", binding.biInput to "bi", binding.bjInput to "bj", binding.bkInput to "bk"
        )

        fun updateVector(b: Boolean, inp: EditText, c: String) {
            val inpVal = inp.text.toString().toDoubleOrNull() ?: 0.0
            if (!b) {
                when (c) {
                    "as" -> vectorA.scale = inpVal
                    "ai" -> vectorA.i     = inpVal
                    "aj" -> vectorA.j     = inpVal
                    "ak" -> vectorA.k     = inpVal
                    "bs" -> vectorB.scale = inpVal
                    "bi" -> vectorB.i     = inpVal
                    "bj" -> vectorB.j     = inpVal
                    "bk" -> vectorB.k     = inpVal
                }
            }
            binding.vectorA.text = vectorA.magnitude().toString()
            binding.vectorB.text = vectorB.magnitude().toString()
            // Log.e(TAG, vectorA.toString())
        }

        vectorInputs.forEach { (input, c) ->
            input.setOnFocusChangeListener { _, b -> updateVector(b, input, c) }
            input.setOnEditorActionListener { _, actionID, _ ->
                updateVector(false, input, c)
                actionID == EditorInfo.IME_ACTION_NEXT
            }
        }



    }
}