package lovely.honey.prison.presenatation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import lovely.honey.prison.R
import lovely.honey.prison.data.repository.UserRepositoryImpl
import lovely.honey.prison.presenatation.adapter.OnboardingAdapter
import lovely.honey.prison.presenatation.adapter.OnboardingItem

class FragmentOnboarding : Fragment() {

    private val userRepository by lazy { UserRepositoryImpl(context = requireContext()) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_onboarding, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewPager = view.findViewById<ViewPager2>(R.id.viewPager)

        val onboardingItems = listOf(
            OnboardingItem(R.drawable.onboarding_pic1, getString(R.string.onboarding_text_1)),
            OnboardingItem(R.drawable.onboarding_pic2, getString(R.string.onboarding_text_2)),
            OnboardingItem(R.drawable.onboarding_pic3, getString(R.string.onboarding_text_3))
        )

        viewPager.adapter = OnboardingAdapter(onboardingItems) {}

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            private var lastPagePosition = 0
            private var scrollState = ViewPager2.SCROLL_STATE_IDLE

            override fun onPageScrollStateChanged(state: Int) {
                super.onPageScrollStateChanged(state)
                scrollState = state

                if (lastPagePosition == onboardingItems.lastIndex &&
                    scrollState == ViewPager2.SCROLL_STATE_DRAGGING
                ) {
                    userRepository.setFirstEnter(false)
                    findNavController().navigate(R.id.action_fragmentOnboarding_to_fragmentMainCraft)
                }
            }

            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                lastPagePosition = position
            }
        })
    }
}