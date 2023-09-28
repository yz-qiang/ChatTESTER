/*
 * Copyright (C) 2009-2013 Matthias Treydte <mt@waldheinz.de>
 *
 * This library is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published
 * by the Free Software Foundation; either version 2.1 of the License, or
 * (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public
 * License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this library; If not, write to the Free Software Foundation, Inc.,
 * 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 */

package de.waldheinz.fs.fat;

import de.waldheinz.fs.BlockDevice;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Iterator;
import de.waldheinz.fs.FsDirectory;
import de.waldheinz.fs.FsDirectoryEntry;
import de.waldheinz.fs.FsFile;
import de.waldheinz.fs.util.RamDisk;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Matthias Treydte &lt;waldheinz at gmail.com&gt;
 */
public class FatFileSystemTest {

    @Test(expected=IllegalStateException.class)
    public void testGetRootClosed() throws IOException {
        System.out.println("getRoot (closed)");
        
        BlockDevice dev = new RamDisk(128 * 1024);
        FatFileSystem fs = SuperFloppyFormatter.get(dev).format();
        fs.close();
        fs.getRoot();
    }
    
    @Test(expected=IllegalStateException.class)
    public void testFlushClosed() throws IOException {
        System.out.println("flush (closed)");
        
        BlockDevice dev = new RamDisk(128 * 1024);
        FatFileSystem fs = SuperFloppyFormatter.get(dev).format();
        fs.close();
        fs.flush();
    }
    
    @Test
    public void testCreateFile() throws IOException {
        System.out.println("createFile");

        BlockDevice dev = new RamDisk(2 * 1024 * 1024);
        

        FatFileSystem fs = SuperFloppyFormatter.get(dev).format();
        FsDirectoryEntry dirEntry =
                fs.getRoot().addFile("This is a file");
        final FsFile fsFile = dirEntry.getFile();
        byte[] nullBytes = new byte[516];
        ByteBuffer buff = ByteBuffer.wrap(nullBytes);
        buff.rewind();
        fsFile.write(0, buff);

        fs.close();

        fs = new FatFileSystem(dev, true);
        
        dirEntry = fs.getRoot().getEntry("This is a file");
        assertNotNull("file is missing", dirEntry);
        assertTrue(dirEntry.isFile());
        final FsFile file = dirEntry.getFile();
        assertNotNull(file);
        assertEquals(516, file.getLength());
    }
    
    @Test
    public void testCreateeSubDirFile() throws IOException {
        System.out.println("createSubDirFile");

        BlockDevice dev = new RamDisk(2 * 1024 * 1024);
        FatFileSystem fs = SuperFloppyFormatter.get(dev).format();
        FsDirectoryEntry dirEntry =
                fs.getRoot().addDirectory("Directory");
        FsDirectoryEntry e = dirEntry.getDirectory().addFile(
                    "This is a file");
        final FsFile fsFile = e.getFile();
        byte[] nullBytes = new byte[516];
        ByteBuffer buff = ByteBuffer.wrap(nullBytes);
        buff.rewind();
        fsFile.write(0, buff);

        fs.close();
        
        fs = new FatFileSystem(dev, true);

        dirEntry = fs.getRoot().getEntry("Directory");
        assertNotNull(dirEntry);

        e = dirEntry.getDirectory().getEntry("This is a file");
        assertNotNull("file is missing", e);
    }

    @Test
    public void testFat12Read() throws Exception {
        System.out.println("testFat12Read");

        final InputStream is = getClass().getResourceAsStream(
                "fat12-test.img.gz");

        final RamDisk rd = RamDisk.readGzipped(is);
        final FatFileSystem fatFs = new FatFileSystem(rd, false);
        final BootSector bs = fatFs.getBootSector();
        
        assertEquals("mkdosfs", bs.getOemName());
        assertEquals(512, bs.getBytesPerSector());
        assertEquals(FatType.FAT12, bs.getFatType());
        assertEquals(4, bs.getSectorsPerCluster());
        assertEquals(1, bs.getNrReservedSectors());
        assertEquals(2, bs.getNrFats());
        assertEquals(512, bs.getRootDirEntryCount());
        assertEquals(2048, bs.getSectorCount());
        assertEquals(0xf8, bs.getMediumDescriptor());
        assertEquals(2, bs.getSectorsPerFat());
        assertEquals(32, bs.getSectorsPerTrack());
        assertEquals(64, bs.getNrHeads());
        assertEquals(0, bs.getNrHiddenSectors());
        assertEquals(512, bs.getFatOffset(0));
        assertEquals(1536, bs.getFatOffset(1));
        assertEquals(2560, bs.getRootDirOffset());

        final FsDirectory fatRootDir = fatFs.getRoot();

        Iterator<FsDirectoryEntry> i = fatRootDir.iterator();
        assertTrue (i.hasNext());

        while (i.hasNext()) {
            final FsDirectoryEntry e = i.next();
            System.out.println("     - " + e);
        }
    }
    
    /**
     * $ cat fat16-test.img.gz | gunzip | hexdump -C
     *
     * @throws Exception
     */
    @Test
    public void testFat16Read() throws Exception {
        System.out.println("testFat16Read");

        final InputStream is = getClass().getResourceAsStream(
                "fat16-test.img.gz");
        
        final RamDisk rd = RamDisk.readGzipped(is);
        final FatFileSystem fatFs = new FatFileSystem(rd, false);
        final BootSector bs = fatFs.getBootSector();
        
        assertEquals("mkdosfs", bs.getOemName());
        assertEquals(512, bs.getBytesPerSector());
        assertEquals(FatType.FAT16, bs.getFatType());
        assertEquals(4, bs.getSectorsPerCluster());
        assertEquals(1, bs.getNrReservedSectors());
        assertEquals(2, bs.getNrFats());
        assertEquals(512, bs.getRootDirEntryCount());
        assertEquals(20000, bs.getSectorCount());
        assertEquals(0xf8, bs.getMediumDescriptor());
        assertEquals(20, bs.getSectorsPerFat());
        assertEquals(32, bs.getSectorsPerTrack());
        assertEquals(64, bs.getNrHeads());
        assertEquals(0, bs.getNrHiddenSectors());
        assertEquals(0x200, bs.getFatOffset(0));
        assertEquals(0x2a00, bs.getFatOffset(1));
        assertEquals(0x5200, bs.getRootDirOffset());
        
        final FsDirectory fatRootDir = fatFs.getRoot();
        
        FsDirectoryEntry entry = fatRootDir.getEntry("testFile");
        assertTrue(entry.isFile());
        assertFalse(entry.isDirectory());

        /* the tests below fail now and then because interpreting the
         * DOS date time fields is locale dependent.
         */
//        assertEquals(1250906972000l, entry.getCreated());
//        assertEquals(1250906972000l, entry.getLastModified());
//        assertEquals(1250899200000l, entry.getLastAccessed());
        
        FsFile file = entry.getFile();
        assertEquals(8, file.getLength());
        
        final FsDirectory rootDir = fatFs.getRoot();
        System.out.println("   rootDir = " + rootDir);

        Iterator<FsDirectoryEntry> i = rootDir.iterator();
        assertTrue (i.hasNext());
        
        while (i.hasNext()) {
            final FsDirectoryEntry e = i.next();
            System.out.println("     - " + e);
        }

        entry = rootDir.getEntry("TESTDIR");
        System.out.println("   testEnt = " + entry);
        assertTrue(entry.isDirectory());
        assertFalse(entry.isFile());

        final FsDirectory testDir = entry.getDirectory();
        System.out.println("   testDir = " + testDir);
        
        i = testDir.iterator();
        
        while (i.hasNext()) {
            final FsDirectoryEntry e = i.next();
            System.out.println("     - " + e);
        }
        
    }

    @Test
    public void testFat32Read() throws Exception {
        System.out.println("fat32Read");
        
        final InputStream is = getClass().getResourceAsStream(
                "fat32-test.img.gz");

        final RamDisk rd = RamDisk.readGzipped(is);
        final FatFileSystem fatFs = new FatFileSystem(rd, false);
        final BootSector bs = fatFs.getBootSector();
        
        assertEquals(FatType.FAT32, bs.getFatType());
        assertEquals("mkdosfs", bs.getOemName());
        assertEquals(512, bs.getBytesPerSector());
        assertEquals(1, bs.getSectorsPerCluster());
        assertEquals(32, bs.getNrReservedSectors());
        assertEquals(2, bs.getNrFats());
        assertEquals(0, bs.getRootDirEntryCount());
        assertEquals(80000, bs.getSectorCount());
        assertEquals(0xf8, bs.getMediumDescriptor());
        assertEquals(616, bs.getSectorsPerFat());
        assertEquals(32, bs.getSectorsPerTrack());
        assertEquals(64, bs.getNrHeads());
        assertEquals(0, bs.getNrHiddenSectors());
        assertEquals(16384, bs.getFatOffset(0));
        assertEquals(16384 + bs.getSectorsPerFat() * bs.getBytesPerSector(),
                bs.getFatOffset(1));
        
        final FsDirectory rootDir = fatFs.getRoot();
        System.out.println("   rootDir = " + rootDir);
        
        Iterator<FsDirectoryEntry> i = rootDir.iterator();
        assertTrue(i.hasNext());
        
        while (i.hasNext()) {
            final FsDirectoryEntry e = i.next();
            System.out.println("     - " + e);
        }

        FsDirectoryEntry e = rootDir.getEntry("Langer Verzeichnisname");
        assertTrue(e.isDirectory());
        assertFalse(e.isFile());

        final FsDirectory dir = e.getDirectory();
        i = dir.iterator();
        assertTrue(i.hasNext());
        
        while (i.hasNext()) {
            e = i.next();
            System.out.println("     - " + e);
        }
    }
    
    @Test
    public void testFat32Write() throws Exception {
        System.out.println("testFat32Write");

        final InputStream is = getClass().getResourceAsStream(
                "fat32-test.img.gz");

        final RamDisk rd = RamDisk.readGzipped(is);
        FatFileSystem fatFs = new FatFileSystem(rd, false);
        assertEquals(FatType.FAT32, fatFs.getFatType());
        FsDirectory rootDir = fatFs.getRoot();

        for (int i=0; i < 1024; i++) {
            final FsDirectoryEntry e = rootDir.addFile("f-" + i);
            assertTrue(e.isFile());
            assertFalse(e.isDirectory());
            final FsFile f = e.getFile();
            
            f.write(0, ByteBuffer.wrap(("this is file # " + i).getBytes()));
        }

        fatFs.close();

        fatFs = new FatFileSystem(rd, false);
        assertEquals(FatType.FAT32, fatFs.getFatType());
        rootDir = fatFs.getRoot();
        
        for (int i=0; i < 1024; i++) {
            assertNotNull(rootDir.getEntry("f-" + i));
        }
    }
}
