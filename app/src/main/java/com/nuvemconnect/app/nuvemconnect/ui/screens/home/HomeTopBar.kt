package com.nuvemconnect.app.nuvemconnect.ui.screens.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.icons.rounded.MoreVert
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@ExperimentalMaterial3Api
@Composable
fun HomeTopBar(
    modifier: Modifier = Modifier,
    onSearchClick: (String) -> Unit = {},
    onMenuClick: () -> Unit = {},
    SearchBarContent: @Composable () -> Unit = {},
    viewModel: HomeViewModel,
) {
    val uiState = viewModel.uiState.collectAsState()
    val text = remember { mutableStateOf("") }
    val active = remember { mutableStateOf(false) }

    Column(
        modifier =
            modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
    ) {
        SearchBar(
            query = uiState.value.query,
            onQueryChange = { viewModel.onQueryChange(it) },
            onSearch = {
                onSearchClick(it)
                active.value = false
            },
            active = active.value,
            onActiveChange = { active.value = it },
            placeholder = { Text(text = "Pesquise no NuvemConnect") },
            leadingIcon = {
                if (!active.value) {
                    Icon(
                        imageVector = Icons.Rounded.Menu,
                        contentDescription = "Menu",
                        modifier =
                            Modifier
                                .clip(RoundedCornerShape(60.dp))
                                .clickable { onMenuClick() },
                    )
                } else {
                    Icon(
                        imageVector = Icons.Rounded.ArrowBack,
                        contentDescription = "Menu",
                        modifier =
                            Modifier
                                .clip(RoundedCornerShape(60.dp))
                                .clickable {
                                    active.value = false
                                    viewModel.resetQuery()
                                },
                    )
                }
            },
            trailingIcon = {
                if (!active.value) {
                    Icon(
                        imageVector = Icons.Rounded.MoreVert,
                        contentDescription = "Search",
                        modifier =
                            Modifier
                                .clip(RoundedCornerShape(60.dp))
                                .clickable { onMenuClick() },
                    )
                } else {
                    Icon(
                        imageVector = Icons.Rounded.Search,
                        contentDescription = "Search",
                        modifier =
                            Modifier
                                .clip(RoundedCornerShape(60.dp))
                                .clickable {
                                    onSearchClick(text.value)
                                    active.value = false
                                },
                    )
                }
            },
        ) {
            SearchBarContent()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
private fun HomeTopBarPreview() {
    HomeTopBar(viewModel = HomeViewModel())
}
