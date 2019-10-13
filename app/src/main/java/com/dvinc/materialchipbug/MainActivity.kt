package com.dvinc.materialchipbug

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.google.android.material.chip.Chip
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        updateButton.setOnClickListener {
            updateAllChips()
        }
    }

    private fun updateAllChips() {
        chipGroup.removeAllViews()
        val chipsTitles = listOf("Tag 1", "Tag 2", "Tag 3", "Tag 4")
        chipsTitles.forEach { title ->
            val chip = createChip(this, title)
            chipGroup.addView(chip)
        }
    }

    private fun createChip(context: Context, chipTitle: String): Chip {
        return Chip(context)
            .apply {
                setTextAppearance(R.style.ChipTextStyle)
                text = chipTitle
                isClickable = false
                isFocusable = false
                setChipBackgroundColorResource(R.color.chipColor)
                setTextColor(ContextCompat.getColor(context, R.color.black))
            }
    }
}
