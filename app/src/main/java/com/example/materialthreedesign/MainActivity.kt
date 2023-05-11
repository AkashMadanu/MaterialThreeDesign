package com.example.materialthreedesign

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material.icons.*
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.*
import androidx.compose.ui.graphics.*
import androidx.compose.ui.layout.*
import androidx.compose.ui.res.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import coil.compose.*
import com.example.materialthreedesign.ui.theme.*
import kotlin.random.*

class MainActivity : ComponentActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialThreeDesignTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colorScheme.background
                ) {
    
                    Scaffold (
                            floatingActionButton = {
                                FloatingActionButton(onClick = {  }) {
                                    Icon(
                                            imageVector = Icons.Default.Add,
                                            contentDescription = null,
                                            tint = MaterialTheme.colorScheme.onPrimaryContainer
                                    )
                    
                                }
                            },
                            topBar = {
                                TopAppBar(
                                        title = {
                                            Text(text = "Material 3")
                                        },
                                        colors = TopAppBarDefaults.smallTopAppBarColors(
                                                containerColor = MaterialTheme.colorScheme.surfaceVariant,
                                                titleContentColor = MaterialTheme.colorScheme.onSurfaceVariant
                                        )
                                )
                            }
                    ){ values->
        
                        LazyColumn(contentPadding = values){
                            items(20){
                                ImageCard(title = "Bacon Ipsum", description = "Bacon ipsum dolor amet tri-tip ratatouille kielbasa pastrami shoulder. Filet mignon tail porchetta buffalo meatball. Tongue ground round filet mignon turkey, drumstick pork chop brisket tri-tip leberkas meatball jerky bresaola pork loin. Prosciutto ball tip turkey salami pig alcatra swine tail pastrami t-bone. Burgdoggen bresaola tongue short ribs, jowl strip steak boudin fatback pork chop hamburger. Tail beef ribs beef ham ham hock jowl meatloaf pork capicola.", modifier = Modifier.padding(16.dp) )
                
                            }
                        }
        
                    }
                    
                }
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview()
{
    MaterialThreeDesignTheme {
    
        Scaffold (
                floatingActionButton = {
                    FloatingActionButton(onClick = {  }) {
                        Icon(
                                imageVector = Icons.Default.Add,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.onPrimaryContainer
                        )
                    
                    }
                },
                topBar = {
                    TopAppBar(
                            title = {
                                Text(text = "Material 3")
                            },
                            colors = TopAppBarDefaults.smallTopAppBarColors(
                                    containerColor = MaterialTheme.colorScheme.surfaceVariant,
                                    titleContentColor = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                    )
                }
        ){ values->
        
            LazyColumn(contentPadding = values){
                items(20){
                    ImageCard(title = "Bacon Ipsum", description = "Bacon ipsum dolor amet  Prosciutto ball tip turkey salami pig alcatra swine tail pastrami t-bone. Burgdoggen bresaola tongue short ribs, jowl strip steak boudin fatback pork chop hamburger. Tail beef ribs beef ham ham hock jowl meatloaf pork capicola.", modifier = Modifier.padding(16.dp) )
                
                }
            }
        
        }
    }
}


@Composable
fun ImageCard(
        title :String,
        description : String,
        modifier: Modifier = Modifier
){
    Card(modifier = modifier.height(650.dp),
            colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surfaceVariant,
                    
                    ),
            shape = MaterialTheme.shapes.large
    ) {
        
        Image(
                painter = painterResource(id = R.drawable.image),
//                painter = rememberAsyncImagePainter(model = "https://picsum.photos/seed/${Random.nextInt()}/300/200"),
                contentDescription = null,
                modifier  = Modifier
                        .clip(MaterialTheme.shapes.large)
                        .fillMaxWidth()
                        .aspectRatio(3f / 2f),
                contentScale = ContentScale.Crop
        
        )
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                    text = title,
                    style = MaterialTheme.typography.titleLarge
            )
            
            Spacer(modifier = Modifier.height(8.dp))
            
            Text(
                    text = description,
                    style = MaterialTheme.typography.bodyMedium
            )
            
            Spacer(modifier = Modifier.height(8.dp))
            
            
            Row(modifier = Modifier
                    .fillMaxWidth()
                    .height(30.dp)
                    .weight(1f)
                    , horizontalArrangement = Arrangement.Center,
                    
                    ) {
                
                
                AssistChip(onClick = {},
                        colors = AssistChipDefaults.assistChipColors(
                                leadingIconContentColor = MaterialTheme.colorScheme.onSurfaceVariant
                        ),
                        leadingIcon = {
                            Icon(imageVector = Icons.Outlined.FavoriteBorder, contentDescription = null)
                        },
                        label = {
                            Text(text = "Mark as favorite")
                        }
                )
                
                Spacer(modifier = Modifier.width(10.dp))
                
                AssistChip(onClick = {},
                        colors = AssistChipDefaults.assistChipColors(
                                leadingIconContentColor = MaterialTheme.colorScheme.onSurfaceVariant
                        ),
                        leadingIcon = {
                            Icon(imageVector = Icons.Outlined.Share, contentDescription = null)
                        },
                        label = {
                            Text(text = "Share with others")
                        }
                )
                
            }
            
            
        }
        
    }}
