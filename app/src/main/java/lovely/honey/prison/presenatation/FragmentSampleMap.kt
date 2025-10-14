package lovely.honey.prison.presenatation

import android.os.Bundle
import android.text.util.Linkify
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import lovely.honey.prison.R
import lovely.honey.prison.databinding.FragmentSampleMapBinding


class FragmentSampleMap : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentSampleMapBinding.inflate(inflater)
        val text = arguments?.getString("MapName")
        val textEscape1 = arguments?.getString("EscapePlan1")
        val textEscape2 = arguments?.getString("EscapePlan2")
        val textEscape3 = arguments?.getString("EscapePlan3")
        val textEscape4 = arguments?.getString("EscapePlan4")
        val titleImageId = arguments?.getInt("TitleImageId")
        val scheduleImageId = arguments?.getInt("ScheduleImageId")
        val jobsImageId = arguments?.getInt("JobsImageId")

        binding.tvMapName.text = text
        binding.tvEscapingPlan1.text = textEscape1
        binding.tvEscapingPlan2.text = textEscape2
        binding.tvEscapingPlan3.text = textEscape3
        binding.tvEscapingPlan4.text = textEscape4
        binding.imPrison.setImageResource(titleImageId!!)
        binding.imSchedule.setImageResource(scheduleImageId!!)
        binding.imJob.setImageResource(jobsImageId!!)

        Linkify.addLinks(binding.tvEscapingPlan1, Linkify.ALL)
        Linkify.addLinks(binding.tvEscapingPlan2, Linkify.ALL)
        Linkify.addLinks(binding.tvEscapingPlan3, Linkify.ALL)
        Linkify.addLinks(binding.tvEscapingPlan4, Linkify.ALL)

        binding.btBack.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentSampleMap_to_fragmentMap)
        }

        return binding.root
    }


}