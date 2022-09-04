package com.fzucco.core.rpg_interfaces;

import com.fzucco.core.interfaces.RPGInterface;
import com.fzucco.core.interfaces.WorldMapInterface;
import com.fzucco.core.root.ContextComponent;
import org.springframework.stereotype.Component;

@Component
public class ShowMap extends ContextComponent implements WorldMapInterface, RPGInterface {

}
