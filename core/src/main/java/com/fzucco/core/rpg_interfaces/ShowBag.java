package com.fzucco.core.rpg_interfaces;

import com.fzucco.core.interfaces.BagInterface;
import com.fzucco.core.interfaces.RPGInterface;
import com.fzucco.core.root.ContextComponent;
import org.springframework.stereotype.Component;

@Component
public class ShowBag extends ContextComponent implements BagInterface, RPGInterface {

}
