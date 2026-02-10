package com.example.catalog.landmark


import com.example.catalog.compose_model.LandmarkInfoTabDVO
import kotlinx.collections.immutable.ImmutableList
import com.example.domain.model.feedback.Rating
import com.example.domain.model.landmark.LandMark
import com.example.domain.model.route.Route

data class LandMarkViewState(

    val landMark: LandMark,
    val isDescriptionCollapsed: Boolean = false,
    val feedbackMessage: String = "",
    val isFeedbackMessageCollapsed: Boolean = false,
    val feedbackRating: Rating = Rating(0f),
    val isFeedbackGraded: Boolean = false,
    val userRoutes: ImmutableList<Route>,
    val isCreateRouteBottomSheetIsVisible: Boolean = false,
    val isAddRouteBottomSheetIsVisible: Boolean = false,
    val newRouteName: String = "",
    val newRouteDescription: String = "",
    val isCreatedRouteDialogIsVisible: Boolean = false,
    val isAddedRouteDialogIsVisible: Boolean = false,
    val serviceUnavailableDialogIsVisible: Boolean = false,
    val isLinkHighlighted: Boolean = false,
    val isWebSiteVisible: Boolean = false,
    val isWebViewMegoVisible: Boolean = false,
    val selectedTab: LandmarkInfoTabDVO = LandmarkInfoTabDVO.Description,
)
